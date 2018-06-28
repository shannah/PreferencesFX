package com.dlsc.preferencesfx.util;

import com.dlsc.preferencesfx.model.Setting;
import javafx.collections.ObservableList;
import java.util.prefs.Preferences;

/**
 * Abstraction for storing values of {@link Setting}.
 * Clients able to provide custom implementations by extending this class.
 *
 * @author François Martin
 * @author Marco Sanfratello
 * @author kivimango
 */

public abstract class AbstractStorageHandler {

    /**
     * Stores the last selected category in TreeSearchView.
     *
     * @param breadcrumb the category path as a breadcrumb string
     */
    public abstract void saveSelectedCategory(String breadcrumb);

    /**
     * Gets the last selected category in TreeSearchView.
     *
     * @return the breadcrumb string of the selected category. null if none is found
     */
    public abstract String loadSelectedCategory();

    /**
     * Stores the given divider position of the MasterDetailPane.
     *
     * @param dividerPosition the divider position to be stored
     */
    public abstract void saveDividerPosition(double dividerPosition);

    /**
     * Gets the stored divider position of the MasterDetailPane.
     *
     * @return the double value of the divider position. 0.2 if none is found
     */
    public abstract double loadDividerPosition();

    /**
     * Stores the window width of the PreferencesFxDialog.
     *
     * @param windowWidth the width of the window to be stored
     */
    public abstract void saveWindowWidth(double windowWidth);

    /**
     * Searches for the window width of the PreferencesFxDialog.
     *
     * @return the double value of the window width. 1000 if none is found
     */
    public abstract double loadWindowWidth();

    /**
     * Stores the window height of the PreferencesFxDialog.
     *
     * @param windowHeight the height of the window to be stored
     */
    public abstract void saveWindowHeight(double windowHeight);

    /**
     * Searches for the window height of the PreferencesFxDialog.
     *
     * @return the double value of the window height. 700 if none is found
     */
    public abstract double loadWindowHeight();

    /**
     * Stores the position of the PreferencesFxDialog in horizontal orientation.
     *
     * @param windowPosX the double value of the window position in horizontal orientation
     */
    public abstract void saveWindowPosX(double windowPosX);

    /**
     * Searches for the horizontal window position.
     *
     * @return the double value of the horizontal window position
     */
    public abstract double loadWindowPosX();

    /**
     * Stores the position of the PreferencesFxDialog in vertical orientation.
     *
     * @param windowPosY the double value of the window position in vertical orientation
     */
    public abstract void saveWindowPosY(double windowPosY);

    /**
     * Searches for the vertical window position.
     *
     * @return the double value of the vertical window position
     */
    public abstract double loadWindowPosY();

    /**
     * Serializes a given Object and saves it to the storage using the given key.
     *
     * @param breadcrumb the key which is used to save the serialized Object
     * @param object     the Object which will be saved
     */
    // asciidoctor Documentation - tag::storageHandlerSave[]
    public abstract void saveObject(String breadcrumb, Object object);
    // asciidoctor Documentation - end::storageHandlerSave[]

    /**
     * Searches in the storage after a serialized Object using the given key,
     * deserializes and returns it. Returns a default Object if nothing is found.
     *
     * @param breadcrumb    the key which is used to search the serialized Object
     * @param defaultObject the Object which will be returned if nothing is found
     * @return the deserialized Object or the default Object if nothing is found
     */
    // asciidoctor Documentation - tag::storageHandlerLoad[]
    public abstract Object loadObject(String breadcrumb, Object defaultObject);
    // asciidoctor Documentation - end::storageHandlerLoad[]

    /**
     * Searches in the storage after a serialized ArrayList using the given key,
     * deserializes and returns it as ObservableArrayList.
     * When an ObservableList is deserialzed, Gson returns an ArrayList
     * and needs to be wrapped into an ObservableArrayList. This is only needed for loading.
     *
     * @param breadcrumb            the key which is used to search the serialized ArrayList
     * @param defaultObservableList the default ObservableList
     *                              which will be returned if nothing is found
     * @return the deserialized ObservableList or the default ObservableList if nothing is found
     */
    public abstract ObservableList loadObservableList(
            String breadcrumb,
            ObservableList defaultObservableList
    );

    /**
     * Clears the storage.
     * @return true if successful, false if there was an exception.
     */
    public abstract boolean clearPreferences();

    public abstract Preferences getPreferences();

}
