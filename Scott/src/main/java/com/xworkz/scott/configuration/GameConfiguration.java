package com.xworkz.scott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.games")
public class GameConfiguration {

    public GameConfiguration() {
        System.out.println("no arg const of GameConfiguration");
    }

    @Bean
    public Map<String, String> getGameGenres() {
        System.out.println("getGameGenres instance created by ApplicationContext");
        Map<String, String> genres = new HashMap<>();
        genres.put("Call of Duty", "Shooter");
        genres.put("FIFA", "Sports");
        genres.put("Assassin's Creed", "Action");
        genres.put("The Sims", "Simulation");
        genres.put("Minecraft", "Sandbox");
        return genres;
    }

    @Bean
    public HashMap<String, Integer> getGameRatings() {
        System.out.println("getGameRatings instance created by ApplicationContext");
        HashMap<String, Integer> ratings = new HashMap<>();
        ratings.put("GTA V", 9);
        ratings.put("Valorant", 8);
        ratings.put("PUBG", 7);
        ratings.put("Fortnite", 6);
        return ratings;
    }

    @Bean
    public LinkedHashMap<String, String> getTopPlayers() {
        System.out.println("getTopPlayers instance created by ApplicationContext");
        LinkedHashMap<String, String> players = new LinkedHashMap<>();
        players.put("PlayerOne", "Call of Duty");
        players.put("Ninja", "Fortnite");
        players.put("Shroud", "Valorant");
        players.put("Myth", "PUBG");
        return players;
    }

    @Bean
    public Map<Integer, String> getLevelDescriptions() {
        System.out.println("getLevelDescriptions instance created by ApplicationContext");
        Map<Integer, String> levels = new HashMap<>();
        levels.put(1, "Beginner");
        levels.put(2, "Intermediate");
        levels.put(3, "Advanced");
        levels.put(4, "Expert");
        return levels;
    }

    @Bean
    public HashMap<String, Double> getGamePrices() {
        System.out.println("getGamePrices instance created by ApplicationContext");
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Elden Ring", 59.99);
        prices.put("Cyberpunk 2077", 49.99);
        prices.put("God of War", 39.99);
        prices.put("Horizon", 29.99);
        return prices;
    }

    @Bean
    public LinkedHashMap<String, Boolean> getMultiplayerSupport() {
        System.out.println("getMultiplayerSupport instance created by ApplicationContext");
        LinkedHashMap<String, Boolean> support = new LinkedHashMap<>();
        support.put("Among Us", true);
        support.put("The Witcher 3", false);
        support.put("Rocket League", true);
        support.put("Celeste", false);
        return support;
    }

    @Bean
    public Map<String, List<String>> getGameDevelopers() {
        System.out.println("getGameDevelopers instance created by ApplicationContext");
        Map<String, List<String>> developers = new HashMap<>();
        developers.put("Ubisoft", Arrays.asList("Assassin's Creed", "Far Cry", "Watch Dogs"));
        developers.put("EA", Arrays.asList("FIFA", "The Sims", "Battlefield"));
        developers.put("Riot Games", Arrays.asList("League of Legends", "Valorant"));
        return developers;
    }

    public HashMap<String, String> getGamePlatforms() {
        System.out.println("getGamePlatforms instance created by ApplicationContext");
        HashMap<String, String> platforms = new HashMap<>();
        platforms.put("Halo", "Xbox");
        platforms.put("Uncharted", "PlayStation");
        platforms.put("Zelda", "Nintendo");
        platforms.put("Valorant", "PC");
        return platforms;
    }

    public LinkedHashMap<String, Integer> getGameDownloads() {
        System.out.println("getGameDownloads instance created by ApplicationContext");
        LinkedHashMap<String, Integer> downloads = new LinkedHashMap<>();
        downloads.put("Subway Surfers", 1000000000);
        downloads.put("Clash of Clans", 500000000);
        downloads.put("Candy Crush", 1000000000);
        downloads.put("Temple Run", 500000000);
        return downloads;
    }

    public Map<String, List<String>> getGameModes() {
        System.out.println("getGameModes instance created by ApplicationContext");
        Map<String, List<String>> modes = new HashMap<>();
        modes.put("Call of Duty", Arrays.asList("Campaign", "Multiplayer", "Zombies"));
        modes.put("Fortnite", Arrays.asList("Solo", "Duo", "Squad"));
        modes.put("Minecraft", Arrays.asList("Survival", "Creative", "Adventure"));
        System.out.println("--------------------------------------------------------");
        return modes;
    }

}
