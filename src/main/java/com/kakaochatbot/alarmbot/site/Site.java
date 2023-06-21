package com.kakaochatbot.alarmbot.site;

import lombok.Getter;

@Getter
public class Site {
    int nx;
    int ny;

    public Site(int nx, int ny) {
        this.nx = nx;
        this.ny = ny;
    }
}
