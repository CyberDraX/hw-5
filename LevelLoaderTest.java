class Level {
    private final int width;
    private final int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException{
        int area = level.getHeight() * level.getWidth();
        if (area > 100000) {
            throw new LevelTooBigException();
        }
        System.out.println("Level loaded");
    }
}

class LevelTooBigException extends Exception {
    LevelTooBigException() {
        super("Level too big");
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}
