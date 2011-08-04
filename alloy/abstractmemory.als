module examples/abstractMemory [Addr, Data]

sig Memory {
	data : Addr -> lone Data
}

fact Canonicalize {
	no disj m, m' : Memory | m.data = m'.data
}

pred init (m : Memory) {
	no m.data
}

pred write (m, m' : Memory, a : Addr, d : Data) {
	m'.data = m.data ++ a-> d
}

pred read (m : Memory, a : Addr, d : Data) {
	let d' = m.data[a] | some d' implies d = d'
}

assert WriteIdempotend {
	all m, m', m'' : Memory, a : Addr, d : Data | write [m, m', a, d] and write [m', m'', a, d] => m' = m''
}

check WriteIdempotend
