mtype { A, AtoB, B, BtoA};
int RbA, RbB, RbS, WoA, WoB, WoS;
mtype Splace;

inline toBank(RbX, WoX)
{
  atomic {
    RbX = RbX + RnS; RbS = 0;
    WoX = WoX + WoS; WoS = 0;
  }
}

inline fromBank(RbX, WoX)
{
  atomic {
  if
  ::(RbX >= 2) -> RbX = RbX - 2; RbS = RbS + 2
  ::(RbX >= 1) -> RbX = RbX - 1; RbS = RbS + 1 
  ::(RbX >= 0) -> skip
  fi;
  if
  ::(WoX >= 2) -> WoX = WoX - 2; WoS = WoS + 2
  ::(WoX >= 1) -> WoX = WoX - 1; WoS = WoS + 1
  ::(WoX >= 0) -> skip 
  }
}

active proctype ship()
{
  RbA = 3;
  RbB = 0;
  RbS = 0;
  WoA = 3;
  WoB = 0;
  WoS = 0;
  Splace = A;

  fromBank(RbA, WoA);
  Splace = AtoB;

  do
  ::(Splace == A) -> toBank(RbA, WoA); fromBank(RbA, WoA); Splace = AtoB
  ::(Splace == AtoB) -> Splace = B
  ::(Splace == B) -> toBank(RbB, WoB); fromBank(RbB, WoB); Splace = BtoA
  ::(Splace == BtoA) -> Splace = A
  od
}


