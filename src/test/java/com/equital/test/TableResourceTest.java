package com.equital.test;

import com.equital.models.TableResource;
import com.equital.test.data.MonsterResource;
import com.equital.test.data.MonsterResourceImp;
import com.equital.test.data.MonstersTableResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TableResourceTest extends ResourceApiTest<TableResource<String, MonsterResource, Integer, ?, ?>> {

    private final List<String> defaultValues;

    private final int newId = 950103;
    private final int wrongId = 141125;

    public TableResourceTest() {
        super(new MonstersTableResource());

        this.defaultValues = Arrays.asList(
                "Anjanath",
                "Barioth",
                "Diablos",
                "Bazelgeuse",
                "Deviljho"
        );
    }

    @Test
    @DisplayName("Every element should be added correctly")
    void add() {
        assertEquals(this.defaultValues.size(), this.resource.size());

        this.resource.add(this.newId, "Kirin");
        assertEquals(this.defaultValues.size() + 1, this.resource.size());
    }

    @Test
    @DisplayName("Every element should be removed correctly")
    void remove() {
        final MonsterResource monster = this.resource.remove(0);

        assertNotNull(monster);
        assertInstanceOf(MonsterResourceImp.class, monster);
        assertEquals(this.defaultValues.size() - 1, this.resource.size());
    }

    @Test
    @DisplayName("After set the resource should override every value it has before")
    void set() {
        Map<Integer, String> newValues = new HashMap<>();
        newValues.put(3, "Anjanath Fulgureo");
        newValues.put(1, "Barioth Cynodon");
        newValues.put(19, "Diablos Negra");
        newValues.put(95, "Bazelgeuse Magma");
        newValues.put(11, "Deviljho Salvaje");

        this.resource.set(newValues);

        assertEquals(newValues.size(), this.resource.size());
        assertIterableEquals(newValues.keySet(), this.resource.get());
    }

    @Test
    @DisplayName("Resource list should be empty")
    void clear() {
        this.resource.clear();
        assertEquals(0, this.resource.size());
    }

    @Test
    @DisplayName("Resource [ list ] should return a list of child resource")
    void list() {
        final Iterable<MonsterResource> monsters = this.resource.list();
        monsters.forEach(monster -> assertInstanceOf(MonsterResourceImp.class, monster));

        assertInstanceOf(Collection.class, monsters);
        assertEquals(((Collection<MonsterResource>) monsters).size(), this.resource.size());
        assertEquals(((Collection<MonsterResource>) monsters).size(), this.defaultValues.size());
    }

    @Test
    @DisplayName("Resource [ table ] should return a map [ key: I, value: Resource ]")
    void table() {
        final Map<Integer, MonsterResource> monsters = this.resource.table();
        monsters.forEach((id, resource) -> assertInstanceOf(MonsterResourceImp.class, resource));
        assertEquals(monsters.size(), this.resource.size());
        assertEquals(monsters.size(), this.defaultValues.size());
    }

    @Test
    @DisplayName("[ valueList ] should return a list of values")
    void valueList() {
        final Iterable<String> monsters = this.resource.valueList();
        assertIterableEquals(this.defaultValues, monsters);
        monsters.forEach(monster -> assertInstanceOf(String.class, monster));
    }

    @Test
    @DisplayName("[ valueTable ] should return a map of [ id, value ]")
    void valueTable() {
        final Map<Integer, String> monsters = this.resource.valueTable();
        assertIterableEquals(this.defaultValues, monsters.values());
        monsters.forEach((id, monster) -> assertInstanceOf(String.class, monster));
    }

    @Test
    @DisplayName("resource.get(id) should return the correct value fot the given [ id ]")
    void get() {
        final Iterable<Integer> ids = this.resource.get();
        ids.forEach(id -> {
            assertInstanceOf(Integer.class, id);

            final MonsterResource monster = this.resource.get(id);
            assertNotNull(monster);
        });

        assertNull(this.resource.get(this.wrongId));
    }

    @Test
    @DisplayName("resource.has(id) should return [ true ] if the id exist in his list and [ false ] if not")
    void has() {
        final String monster = "Teostra";
        this.resource.add(this.newId, monster);

        assertTrue(this.resource.has(this.newId));
        assertFalse(this.resource.has(this.wrongId));
    }

    @BeforeEach
    void init() {
        final Map<Integer, String> values = new HashMap<>();
        for (int i = 0; i < this.defaultValues.size(); i++) {
            values.put(i, this.defaultValues.get(i));
        }

        this.resource.add(values);
    }
}