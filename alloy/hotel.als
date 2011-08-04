module examples/hotel
open util/ordering[Time]
open util/ordering[Key]

-- signetures
sig Key {}
sig Time {}
sig Room {
	keys : set Key,
	currentKey : keys one -> Time
}

sig Guest {
	keys : Key -> Time
}

fact DisjointKeySets {
	Room <: keys in Room lone -> Key
}

one sig FrontDesk {
	lastKey : (Room -> lone Key) -> Time,
	occupaint : (Room -> Guest) -> Time
}

fun nextKey (k : Key, ks : set Key) : lone Key {
	min[k.nexts & ks]
}

pred init (t : Time) {
	no Guest.keys.t
	no FrontDesk.occupaint.t
	all r : Room | FrontDesk.lastKey.t [r] = r.currentKey.t
}

pred entry (t , t' : Time, g : Guest, r : Room, k : Key) {
	k in g.keys.t
	let ck = r.currentKey | (k = ck.t and ck.t' = ck.t) or (k = nextKey [ck.t, r.keys] and ck.t' = k)
	noRoomChangeExcept [t, t', r]
	noGuestChangeExcept [t, t', none]
	noFrontDeskChange [t, t']
}

pred noRoomChangeExcept (t, t': Time, rs : set Room) {
	all r : Room - rs | r.currentKey.t = r.currentKey.t'
}

pred  noGuestChangeExcept(t, t' : Time, gs : set Guest) {
	all g : Guest - gs | g.keys.t = g.keys.t'
}

pred noFrontDeskChange (t, t' : Time) {
	FrontDesk.lastKey.t = FrontDesk.lastKey.t'
	FrontDesk.occupaint.t = FrontDesk.occupaint.t'
}


pred checkout (t, t' : Time, g : Guest) {
	let occ = FrontDesk.occupaint {
		some occ.t.g
		occ.t' = occ.t - Room -> g
	}
	FrontDesk.lastKey.t =FrontDesk.lastKey.t'
	noRoomChangeExcept [t, t', none]
	noGuestChangeExcept [t, t', none]
}

pred checkin (t, t' : Time, g : Guest, r : Room, k : Key) {
	g.keys.t' = g.keys.t + k
	let occ = FrontDesk.occupaint {
		no occ.t [r]
		occ.t' = occ.t + r  -> g
	}
	let lk = FrontDesk.lastKey {
		lk.t' = lk.t ++ r -> k
		k = nextKey [lk.t [r], r.keys]
	}
	noRoomChangeExcept [t, t', none]
	noGuestChangeExcept [t, t', g]
}

fact Traces {
	first.init
	all t : Time - last | let t' = t.next | some g : Guest, r : Room, k : Key | 
		entry [t, t', g, r, k]
		or checkin [t, t', g, r, k]
		or checkout [t, t', g]
}

assert NoBadEntry {
	all t : Time, r : Room, g : Guest, k : Key |
	let o = FrontDesk.occupaint.t [r] | entry [t, t.next, g, r, k] and some o => g in o
}


check NoBadEntry for 3 but 2 Room, 2 Guest, 5 Time

fact NoIntervening {
	all t : Time - last | let t'= t.next, t'' = t'.next | all g : Guest, r : Room, k : Key |
	checkin[t, t', g, r, k] => (entry[t', t'', g, r, k] or no t'')
}

