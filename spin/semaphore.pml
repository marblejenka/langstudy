mtype = { idle, entering, critical, exiting };
bool semaphore = false;
mtype state_p1, state_p2;

inline request(p)
{
  atomic {
    (semaphore == false) -> semaphore = true; p = critical
  }
}

inline release(p)
{
  atomic {
    semaphore = false; p = idle
  }
}

active proctype p1()
{
  state_p1 = idle;
  
  do
  ::state_p1 == idle -> skip
  ::state_p1 == idle -> state_p1 = entering
  ::state_p1 == entering -> request(state_p1)
  ::state_p1 == critial -> skip
  ::state_p1 == critial -> state_p1 = exiting
  ::state_p1 == exiting -> release(state_p1)
  od
}

active proctype p2()
{
  state_p2 = idle;
  
  do
  ::state_p2 == idle -> skip
  ::state_p2 == idle -> state_p2 = entering
  ::state_p2 == entering -> request(state_p2)
  ::state_p2 == critial -> skip
  ::state_p2 == critial -> state_p2 = exiting
  ::state_p2 == exiting -> release(state_p2)
  od
}

