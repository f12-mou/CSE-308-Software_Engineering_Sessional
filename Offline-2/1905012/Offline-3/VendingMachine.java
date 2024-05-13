package com.company;

public class VendingMachine {
    State noProductState;
    State waitingForRequestState;
    State collectionMoneyState;
    State xtraAmountState;
    State releasingState;

    State state;
    int count;
    int price;
    int quarter;
    int mismatchAmount;

    public VendingMachine(int count, int price, int quarter) {
        collectionMoneyState = new CollectionMoneyState(this);
        noProductState = new NoProductState(this);
        waitingForRequestState = new WaitingForRequestState(this);
        xtraAmountState = new XtraAmountState(this);
        releasingState = new ReleasingState(this);
        state = noProductState;
        this.count = count;
        this.price = price;
        this.quarter = quarter;
        mismatchAmount=0;
    }

    public State getCollectionMoneyState() {
        return collectionMoneyState;
    }

    public State getNoProductState() {
        return noProductState;
    }

    public State getXtraAmountState() {
        return xtraAmountState;
    }

    public State getReleasingState(){return  releasingState;}

    public State getWaitingForRequestState() {
        return waitingForRequestState;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public void getRequest(){ state.getRequest();}
    public void dispenseItem(){ state.dispenseItem();}
    public void insertItem(){state.insertItem();}
    public void collectMoney(){state.collectMoney();}
    public void sendBackMoney(){state.sendBackMoney();}
    public void print()
    {
        state.printCurrentSituation();
    }
}
