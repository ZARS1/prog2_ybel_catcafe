package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class CatCafeTest {
    @Test
    void givenEmptyCafe_whenGetCatCount_thenReturnsZero() {
        CatCafe cafe = new CatCafe();

        long catCount = cafe.getCatCount();

        assertEquals(0, catCount);
    }

    @Test
    void givenEmptyCafe_whenAddCat_thenCatCountIsOne() {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Minka", 4));

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenCafe_whenAddTwoCatsWithDifferentWeights_thenCatCountIsTwo() {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Minka", 4));
        cafe.addCat(new FelineOverLord("Garfield", 8));

        assertEquals(2, cafe.getCatCount());
    }

    @Test
    void givenCafe_whenAddTwoCatsWithSameWeight_thenCatCountIsOne() {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Minka", 4));
        cafe.addCat(new FelineOverLord("Luna", 4));

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenCafe_whenAddNullCat_thenThrowsNullPointerException() {
        CatCafe cafe = new CatCafe();

        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }

    @Test
    void givenCafeWithCat_whenGetCatByName_thenReturnsMatchingCat() {
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);
        cafe.addCat(cat);

        Optional<FelineOverLord> result = cafe.getCatByName("Morticia");

        assertTrue(result.isPresent());
        assertEquals(cat, result.get());
    }

    @Test
    void givenCafeWithCat_whenGetCatByUnknownName_thenReturnsEmptyOptional() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        Optional<FelineOverLord> result = cafe.getCatByName("Garfield");

        assertTrue(result.isEmpty());
    }

    @Test
    void givenCafeWithCat_whenGetCatByNullName_thenReturnsEmptyOptional() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        Optional<FelineOverLord> result = cafe.getCatByName(null);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenCafeWithCat_whenGetCatByWeightInsideRange_thenReturnsMatchingCat() {
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Gwenapurr", 3);
        cafe.addCat(cat);

        Optional<FelineOverLord> result = cafe.getCatByWeight(3, 4);

        assertTrue(result.isPresent());
        assertEquals(cat, result.get());
    }

    @Test
    void givenCafeWithCat_whenGetCatByWeightAtUpperLimit_thenReturnsEmptyOptional() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Gwenapurr", 4));

        Optional<FelineOverLord> result = cafe.getCatByWeight(3, 4);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenCafeWithCat_whenGetCatByNegativeMinimumWeight_thenReturnsEmptyOptional() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Gwenapurr", 3));

        Optional<FelineOverLord> result = cafe.getCatByWeight(-1, 4);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenCafeWithCat_whenGetCatByInvalidWeightRange_thenReturnsEmptyOptional() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Gwenapurr", 3));

        Optional<FelineOverLord> result = cafe.getCatByWeight(5, 3);

        assertTrue(result.isEmpty());
    }
}