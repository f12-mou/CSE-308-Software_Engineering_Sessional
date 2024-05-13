package com.company;

public class ImposterAdapter implements GoodPassenger{
    private Imposter imposter;

    public ImposterAdapter(Imposter imposter) {
        this.imposter = imposter;
    }
    @Override
    public void study() {
        System.out.println("The Study Method is called from ImposterAdapter Class.");
        imposter.poison();
    }
    @Override
    public void maintain() {
        System.out.println("The Maintain Method is called from ImposterAdapter Class.");
        imposter.damage();
    }
}
