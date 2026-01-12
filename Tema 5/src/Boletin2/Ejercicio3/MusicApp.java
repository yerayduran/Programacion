package Boletin2.Ejercicio3;

public class MusicApp {

    static void main(String[] args) {

        OnlineMusicPlayer spotify = new Spotify();
        OfflineMusicPlayer iTunes = new iTunes();
        OfflineMusicPlayer mp3 = new MP3Player();

        MusicPlayer[] musicPlayers = {spotify, iTunes, mp3};

        startMusic(musicPlayers);
    }

    public static void startMusic(MusicPlayer[] musicPlayers) {

        for (MusicPlayer musicPlayer : musicPlayers) {

            if(musicPlayer instanceof OnlineMusicPlayer onlineMusicPlayer) {
                onlineMusicPlayer.stream();
            }
            if(musicPlayer instanceof OfflineMusicPlayer offlineMusicPlayer) {
                offlineMusicPlayer.load();
            }

            musicPlayer.play();
            musicPlayer.stop();
        }
    }
}

