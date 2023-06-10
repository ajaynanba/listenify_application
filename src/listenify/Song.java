package listenify;
public class Song {

    public String songName;
    public double duration;

    public Song(String songName,double duration){
        this.songName = songName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song='" + songName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
