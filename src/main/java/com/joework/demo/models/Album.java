package com.joework.demo.models;

import javax.persistence.*;


@Entity
public class Album {

    private String instrumentId;
    private Singer singer;

    @Id
    @Column(name = "INSTRUMENT_ID")
    public String getInstrumentId() {
        return this.instrumentId;
    }
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }
    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    public Singer getSinger() {
        return this.singer;
    }
    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
