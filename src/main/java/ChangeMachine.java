public class ChangeMachine {
  private int mQuarters;
  private int mDimes;
  private int mNickels;
  private int mPennies;

  public ChangeMachine() {
    mQuarters = 20;
    mDimes = 20;
    mNickels = 20;
    mPennies = 20;
  }

  public int getQuarters(){
    return mQuarters;
  }

  public int getDimes(){
    return mDimes;
  }

  public int getNickels(){
    return mNickels;
  }

  public int getPennies(){
    return mPennies;
  }

  public int makeQuarterChange(Float totalCash){
    int quarterChangeQuantity = 0;
    while (totalCash > 0.25f && mQuarters > 0){
      totalCash -= 0.25f;
      quarterChangeQuantity += 1;
      mQuarters -= 1;
    }
    return quarterChangeQuantity;
  }

  public int makeDimeChange(Float totalCash){
    int dimeChangeQuantity = 0;
    while (totalCash > 0.10f && mDimes > 0){
      totalCash -= 0.10f;
      dimeChangeQuantity += 1;
      mDimes -= 1;
    }
    return dimeChangeQuantity;
  }

  public int makeNickelChange(Float totalCash){
    int nickelChangeQuantity = 0;
    while (totalCash > 0.05f && mNickels > 0){
      totalCash -= 0.05f;
      nickelChangeQuantity += 1;
      mNickels -= 1;
    }
    return nickelChangeQuantity;
  }

  public int makePennyChange(Float totalCash){
    int pennyChangeQuantity = 0;
    while (totalCash > 0.01f && mPennies > 0){
      totalCash -= 0.01f;
      pennyChangeQuantity += 1;
      mPennies -= 1;
    }
    return pennyChangeQuantity;
  }

  public String makeChange(Float totalCash){
    int quarterChangeTotal = makeQuarterChange(totalCash);
    float updatedCashTotal = totalCash - (((float) quarterChangeTotal) * 0.25f);
    int dimeChangeTotal = makeDimeChange(updatedCashTotal);
    updatedCashTotal -= (((float) dimeChangeTotal) * 0.10f);
    int nickelChangeTotal = makeNickelChange(updatedCashTotal);
    updatedCashTotal -= (((float) nickelChangeTotal) * 0.05f);
    int pennyChangeTotal = makePennyChange(updatedCashTotal);
    return String.format("Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d", quarterChangeTotal, dimeChangeTotal, nickelChangeTotal, pennyChangeTotal);
  }

}
