package com.xworkz.scott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.xworkz.scott.fashion")
public class FashionConfiguration {

    public FashionConfiguration() {
        System.out.println("FashionConfiguration no arg const");
    }

    @Bean
    public Collection<String> getTopBrands() {
        System.out.println("getTopBrands instance created by ApplicationContext");
        return Arrays.asList("Zara", "H&M", "Gucci", "Prada", "Uniqlo");
    }

    @Bean
    public Set<String> getClothingTypes() {
        System.out.println("getClothingTypes instance created by ApplicationContext");
        return new HashSet<>(Arrays.asList("Shirt", "T-Shirt", "Jeans", "Dress", "Jacket"));
    }

    @Bean
    public HashSet<String> getShoeBrands() {
        System.out.println("getShoeBrands instance created by ApplicationContext");
        return new HashSet<>(Arrays.asList("Nike", "Adidas", "Puma", "Reebok", "Fila"));
    }

    @Bean
    public TreeSet<String> getSortedAccessories() {
        System.out.println("getSortedAccessories instance created by ApplicationContext");
        return new TreeSet<>(Arrays.asList("Watch", "Belt", "Scarf", "Sunglasses", "Hat"));
    }

    @Bean
    public LinkedHashSet<String> getOrderedBagBrands() {
        System.out.println("getOrderedBagBrands instance created by ApplicationContext");
        return new LinkedHashSet<>(Arrays.asList("Louis Vuitton", "Coach", "Michael Kors", "Gucci", "Hermès"));
    }

    @Bean
    public Collection<String> getColorsInFashion() {
        System.out.println("getColorsInFashion instance created by ApplicationContext");
        return Arrays.asList("Black", "White", "Beige", "Pastel Pink", "Olive Green");
    }

    @Bean
    public Set<Integer> getAvailableSizes() {
        System.out.println("getAvailableSizes instance created by ApplicationContext");
        return new HashSet<>(Arrays.asList(28, 30, 32, 34, 36));
    }

    @Bean
    public HashSet<String> getUnisexItems() {
        System.out.println("getUnisexItems instance created by ApplicationContext");
        return new HashSet<>(Arrays.asList("Hoodie", "Sneakers", "Cap", "Backpack"));
    }

    @Bean
    public TreeSet<String> getSeasonalTrends() {
        System.out.println("getSeasonalTrends instance created by ApplicationContext");
        return new TreeSet<>(Arrays.asList("Floral", "Denim", "Leather", "Metallic", "Boho"));
    }

    @Bean
    public LinkedHashSet<String> getLimitedEditionItems() {
        System.out.println("getLimitedEditionItems instance created by ApplicationContext");
        System.out.println("------------------------------------------------------------");
        return new LinkedHashSet<>(Arrays.asList("Designer Jacket", "Limited Sneakers", "Runway Dress", "Collector Watch"));
    }

}
