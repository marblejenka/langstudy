module examples/ringElection
open util/ordering[Time]
open util/ordering[Process]

sig Time {}

sig Process {
	succ : Process,
	toSend : Process -> Time,
	elected : set Time
}

fact Ring { all p : Process | Process in p.^succ }
pred init (t : Time) { all p : Process | p.toSend.t = p }

pred step (t, t' : Time, p : Process) {
	let from = p.toSend, to = p.succ.toSend | some id : from.t {
		from.t' = from.t - id
		to.t' = to.t + (id - p.succ.prevs)
	}
}

pred skip (t, t' : Time, p : Process) { p.toSend.t = p.toSend.t' }

fact Traces {
	first.init
	all t : Time - last | let t' = t.next | all p : Process | step [t, t', p] or step [t, t', succ.p] or skip [t, t', p]
}

fact DefineElected {
	no elected.first
	all t : Time - last | elected.t = { p:Process | p in p.toSend.t - p.toSend.(t.prev) }
}

assert AtMostOneElected { lone elected.Time }
check AtMostOneElected for 3 Process, 7 Time

pred progress {
	all t : Time - last | let t' = t.next | some Process.toSend.t => some p : Process| not skip [t, t', p]
}

assert AtLeastOneElected {
	progress => some elected.Time
}

pred looplessPath { no disj t, t' : Time | toSend.t = toSend.t' }
run looplessPath for 13 Time, 3 Process

pred show {
	some elected
}
run show for 3 Process, 4 Time
