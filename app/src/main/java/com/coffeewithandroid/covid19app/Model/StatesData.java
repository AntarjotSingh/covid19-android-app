package com.coffeewithandroid.covid19app.Model;

public class StatesData {

    private String state, confirmed, confirmedDelta, active, activeDelta, recovered, recoveredDelta, deceased, deceasedDelta;

    public StatesData() {
    }

    public StatesData(String state,String  confirmed,String  confirmedDelta,String  active,String  activeDelta,String  recovered,String  recoveredDelta,String  deceased,String  deceasedDelta) {
        this.state = state;
        this.confirmed = confirmed;
        this.confirmedDelta = confirmedDelta;
        this.active =  active;
        this.activeDelta = activeDelta;
        this.recovered = recovered;
        this.recoveredDelta = recoveredDelta;
        this.deceased = deceased;
        this.deceasedDelta = deceasedDelta;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getConfirmedDelta() {
        return confirmedDelta;
    }

    public void setConfirmedDelta(String confirmedDelta) {
        this.confirmedDelta = confirmedDelta;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActiveDelta() {
        return activeDelta;
    }

    public void setActiveDelta(String activeDelta) {
        this.activeDelta = activeDelta;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getRecoveredDelta() {
        return recoveredDelta;
    }

    public void setRecoveredDelta(String recoveredDelta) {
        this.recoveredDelta = recoveredDelta;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getDeceasedDelta() {
        return deceasedDelta;
    }

    public void setDeceasedDelta(String deceasedDelta) {
        this.deceasedDelta = deceasedDelta;
    }
}
