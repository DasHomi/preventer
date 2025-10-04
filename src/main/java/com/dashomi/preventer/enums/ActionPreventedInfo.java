package com.dashomi.preventer.enums;

public enum ActionPreventedInfo {
    OFF, // no action prevented info shown
    MINIMAL, // displays a small icon above the hotbar
    DEFAULT, // displays a general action prevented message above the hotbar
    AUDIO, // plays a sound when an action is prevented
    LEGACY // displays module specific message for each module implemented before 2.0 above hotbar
}
