
abstract class Book {
    protected String title;
    protected String author;
    protected int year;

    protected static int objectCount = 0; 
    public Book() {
        this.title = "";
        this.author = "";
        this.year = 0;
        objectCount++;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        objectCount++;
    }

    public abstract void ShowInfo();

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public void ShowData() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год: " + year);
    }

    public static void showObjectCount() {
        System.out.println("Всего создано объектов: " + objectCount);
    }
}


class AudioBook extends Book {
    private double duration; 
    private String narrator; 
    public AudioBook() {
        super();
        this.duration = 0.0;
        this.narrator = "";
    }

    public AudioBook(String title, String author, int year, double duration, String narrator) {
        super(title, author, year);
        this.duration = duration;
        this.narrator = narrator;
    }

    @Override
    public void ShowInfo() {
        System.out.println("\nАУДИОКНИГА:");
        ShowData();
        System.out.println("Длительность: " + duration + " ч");
        System.out.println("Чтец: " + narrator);
    }

    public void play() {
        System.out.println("Воспроизведение аудиокниги \"" + title + "\"...");
    }

    public void stop() {
        System.out.println("Остановка воспроизведения.");
    }
}

class Film extends Book {
    protected String director;
    protected double duration; 

    public Film() {
        super();
        this.director = "";
        this.duration = 0.0;
    }

    public Film(String title, String author, int year, String director, double duration) {
        super(title, author, year);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void ShowInfo() {
        System.out.println("\nФИЛЬМ:");
        ShowData();
        System.out.println("Режиссёр: " + director);
        System.out.println("Длительность: " + duration + " мин");
    }

    public void play() {
        System.out.println("Воспроизведение фильма \"" + title + "\"...");
    }

    public void stop() {
        System.out.println("Остановка фильма.");
    }
}

class Musical extends Film {
    private final int songCount;

    public Musical() {
        super();
        this.songCount = 0;
    }

    public Musical(String title, String author, int year, String director, double duration, int songCount) {
        super(title, author, year, director, duration);
        this.songCount = songCount;
    }

    @Override
    public void ShowInfo() {
        System.out.println("\nМЮЗИКЛ:");
        ShowData();
        System.out.println("Режиссёр: " + director);
        System.out.println("Длительность: " + duration + " мин");
        System.out.println("Количество песен: " + songCount);
    }

    public void sing() {
        System.out.println("Исполняется песня из мюзикла \"" + title + "\"!");
    }
}


public class Main {
    public static void main(String[] args) {
        AudioBook audio = new AudioBook("1984", "Джордж Оруэлл", 1949, 10.5, "Иван Иванов");
        Film f = new Film("Интерстеллар", "Джонатан Нолан", 2014, "Кристофер Нолан", 169);
        Musical m = new Musical("Отверженные", "Виктор Гюго", 2012, "Том Хупер", 158, 20);

        audio.ShowInfo();
        audio.play();

        f.ShowInfo();
        f.play();

        m.ShowInfo();
        m.sing();

        System.out.println();
        Book.showObjectCount();

    }
}
