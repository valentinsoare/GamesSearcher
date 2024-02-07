/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package databases;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Simulates database
 */
public class Database {
    /// Game Name -> (Rating, Price)
    private Map<String, List<Float>> GAME_TO_PRICE = Map.of("Fortnite", Arrays.asList(5f, 10f),
            "Minecraft", Arrays.asList(4.3f, 100f),
            "League Of Legends", Arrays.asList(4.9f, 89f),
            "Ace Combat", Arrays.asList(4.8f, 50f),
            "StarCraft", Arrays.asList(4.7f, 66f),
            "Burnout", Arrays.asList(4.4f, 31f));


    public Set<String> readAllGames() {
        return Collections.unmodifiableSet(GAME_TO_PRICE.keySet());
    }

    public Map<String, Float> readGameToRatings(Set<String> games) {
        return GAME_TO_PRICE.entrySet()
                .stream()
                .filter(entry -> games.contains(entry.getKey()))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> entry.getValue().get(0)));
    }

    public Map<String, Float> readGameToPrice(Set<String> games) {
        return GAME_TO_PRICE.entrySet()
                .stream()
                .filter(entry -> games.contains(entry.getKey()))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> entry.getValue().get(1)));
    }
}
