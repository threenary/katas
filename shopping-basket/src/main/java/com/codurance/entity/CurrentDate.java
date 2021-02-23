package com.codurance.entity;

import java.time.LocalDate;

public class CurrentDate implements DateProvider {

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }
}
