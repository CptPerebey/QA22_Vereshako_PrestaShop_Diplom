package enums;

public enum State {
    ALASKA("Alaska"), ARIZONA("Arizona"), ARKANSAS("Arkansas"), CALIFORNIA("California"),
    COLORADO("Colorado"), CONNECTICUT("Connecticut"), DELAWARE("Delaware");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static State fromString(String value) {
        for (State state : State.values()) {
            if (state.getName().equals(value)) {
                return state;
            }
        }
        return null;
    }
}
