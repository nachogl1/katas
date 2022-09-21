package com.katas.ants;

public enum AntDirection {
    NORTH("NORTH") {
        @Override
        public AntDirection turnRight() {
            return AntDirection.EAST;
        }

        @Override
        public AntDirection turnLeft() {
            return AntDirection.WEST;
        }

        @Override
        public AntCoordinate move(AntCoordinate antCoordinate) {
            return new AntCoordinate(antCoordinate.x(), antCoordinate.y() + 1);
        }
    }, EAST("EAST") {
        @Override
        public AntDirection turnRight() {
            return AntDirection.SOUTH;
        }

        @Override
        public AntDirection turnLeft() {
            return AntDirection.NORTH;
        }

        @Override
        public AntCoordinate move(AntCoordinate antCoordinate) {
            return new AntCoordinate(antCoordinate.x() + 1, antCoordinate.y());
        }
    }, SOUTH("SOUTH") {
        @Override
        public AntDirection turnRight() {
            return AntDirection.WEST;
        }

        @Override
        public AntDirection turnLeft() {
            return AntDirection.EAST;
        }


        @Override
        public AntCoordinate move(AntCoordinate antCoordinate) {
            return new AntCoordinate(antCoordinate.x(), antCoordinate.y() - 1);
        }
    }, WEST("WEST") {
        @Override
        public AntDirection turnRight() {
            return AntDirection.NORTH;
        }

        @Override
        public AntDirection turnLeft() {
            return AntDirection.SOUTH;
        }


        @Override
        public AntCoordinate move(AntCoordinate antCoordinate) {
            return new AntCoordinate(antCoordinate.x() - 1, antCoordinate.y());
        }
    };

    private final String direction;

    AntDirection(String direction) {
        this.direction = direction;
    }

    public AntCoordinate move(AntCoordinate antCoordinate) {
        return new AntCoordinate(0, 0);
    }

    public AntDirection turnRight() {
        return AntDirection.NORTH;
    }

    public AntDirection turnLeft() {
        return AntDirection.NORTH;
    }
}
