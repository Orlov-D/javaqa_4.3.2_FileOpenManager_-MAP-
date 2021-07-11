package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager fileOpenManager = new FileOpenManager();

    @BeforeEach
    void setUP() {
        fileOpenManager.newElement(".jpg", new HashSet<>(Arrays.asList("Photoshop", "Фоторедактор", "Paint")));
        fileOpenManager.newElement(".PSD", new HashSet<>(Collections.singletonList("Photoshop")));
        fileOpenManager.newElement(".txt", new HashSet<>());
        fileOpenManager.newElement(".xls", new HashSet<>(Collections.singletonList("Excel")));
        fileOpenManager.newElement(".md5", new HashSet<>());
    }

    @Test
    public void shouldGetAppsNameViaExtension() {
//2. Получать название приложения, предназначенного для открытия файла с определённым расширением.
        assertEquals(new HashSet<String>(Arrays.asList("Photoshop", "Фоторедактор", "Paint")), fileOpenManager.getAppName(".jpg"));
    }

    @Test
    public void shouldAddNewAppName() {
//1. Регистрировать новое приложение для открытия файлов с определённым расширением
        fileOpenManager.newApp(".Jpg", "фотоМАСТЕР");
        assertEquals(new HashSet<String>(Arrays.asList("Photoshop", "Фоторедактор", "Paint", "фотоМАСТЕР")), fileOpenManager.getAppName(".jpg"));
    }

    @Test
    public void shouldGetExtensions() {
//4. Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
        assertEquals(new HashSet<String>(Arrays.asList(".jpg", ".psd", ".xls")), fileOpenManager.getExtensionWithApps());
    }

    @Test
    public void shouldGetAllAppsName() {
//5. Получать список всех приложений, которые привязаны к каким-либо расширениям
        assertEquals(new HashSet<String>(Arrays.asList("Photoshop", "Фоторедактор", "Paint", "Excel")), fileOpenManager.getAppsWithExtension());
    }
    @Test
    public void shouldDeleteAppsName() {
//3. Удалять привязку приложения к определённому расширению
//Так как в слаке никто не успел ответить, реализовал два удаления. Но так как задание одно, то и тест один)))
        fileOpenManager.delete(".txt");
        assertEquals(false, fileOpenManager.containsExtension(".txt"));

        fileOpenManager.deleteRich(".jpG", "Photoshop");
        assertEquals(new HashSet<String>(Arrays.asList("Фоторедактор", "Paint")), fileOpenManager.getAppName(".jpg"));
    }
}