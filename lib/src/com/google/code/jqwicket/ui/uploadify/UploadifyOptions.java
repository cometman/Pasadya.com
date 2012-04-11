/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.jqwicket.ui.uploadify;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.api.JQLiteral;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class UploadifyOptions extends AbstractJQOptions<UploadifyOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            UploadifyOptions.class, "jquery.uploadify.v2.1.4.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            UploadifyOptions.class, "jquery.uploadify.v2.1.4.min.js");

    public static final JavaScriptResourceReference JS_SWFOBJ_RESOURCE = new JavaScriptResourceReference(
            UploadifyOptions.class, "swfobject.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            UploadifyOptions.class, "uploadify.css");

    public static final CssResourceReference SWF_UPLOADIFY_RESOURCE = new CssResourceReference(
            UploadifyOptions.class, "uploadify.swf");

    public static final CssResourceReference SWF_EXPRESS_INSTALL_RESOURCE = new CssResourceReference(
            UploadifyOptions.class, "expressInstall.swf");

    public static final CssResourceReference PNG_CANCEL_RESOURCE = new CssResourceReference(
            UploadifyOptions.class, "cancel.png");

    public enum DisplayDataType {
        PERCENTAGE, SPEED;
    }

    public enum Wmode {
        OPAQUE, TRANSPARENT;
    }

    public UploadifyOptions() {
        this.setJsResourceReferences(JS_SWFOBJ_RESOURCE, JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_SWFOBJ_RESOURCE, JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * Enabling the auto option will automatically begin uploading files when they are added to the file upload
     * queue.<br> Default:false<br> Required:optional
     *
     * @param auto
     * @return
     */
    public UploadifyOptions auto(boolean auto) {
        super.put("auto", auto);
        return this;
    }

    /**
     * The buttonImg option allows you to set a custom image for the flash button.<br> Default:null<br>
     * Required:optional
     *
     * @param buttonImg
     * @return
     */
    public UploadifyOptions buttonImg(CharSequence buttonImg) {
        super.put("buttonImg", buttonImg);
        return this;
    }

    /**
     * The buttonText option allows you to change the text that appears on the default button.<br> Default:'SELECT
     * FILES'<br> Required:optional
     *
     * @param buttonText
     * @return
     */
    public UploadifyOptions buttonText(CharSequence buttonText) {
        super.put("buttonText", buttonText);
        return this;
    }

    /**
     * The cancelImg option points to the image file that will be displayed as the cancel button on each file queue
     * item. Any image file can be used. cancel.png is included in the zip package if you’d like to use the default
     * styling.<br> Default:'cancel.png'<br> Required:required
     *
     * @param cancelImg
     * @return
     */
    public UploadifyOptions cancelImg(CharSequence cancelImg) {
        super.put("cancelImg", cancelImg);
        return this;
    }

    /**
     * The checkScript option allows you to check the upload folder for any files that exist with the same name as any
     * files that are in the queue for upload. The back-end script should return a JSON encoded array of the matching
     * file names in order for this option to work.<br> Default:null<br> Required:optional
     *
     * @param checkScript
     * @return
     */
    public UploadifyOptions checkScript(CharSequence checkScript) {
        super.put("checkScript", checkScript);
        return this;
    }

    /**
     * The displayData option determines what data is displayed in the file upload queue item during an upload. By
     * default, the percentage complete is shown. You can set the value to "speed" to display the average upload speed
     * in KB/s.<br> Default:'percentage'<br> Required:optional
     *
     * @param displayData
     * @return
     */
    public UploadifyOptions displayData(DisplayDataType displayData) {
        super.put("displayData", displayData);
        return this;
    }

    /**
     * The expressInstall option points to the flash expressInstall.swf file that is used by the system to install flash
     * if it does not exist.<br> Default:null<br> Required:optional
     *
     * @param expressInstall
     * @return
     */
    public UploadifyOptions expressInstall(CharSequence expressInstall) {
        super.put("expressInstall", expressInstall);
        return this;
    }

    /**
     * The fileDataName option sets the name of the file input that the flash file uses when uploading the files. This
     * value is used for referencing the files that have been uploaded in your back-end script. For example, if you set
     * the value of fileDataName to ‘uploadify’, you would reference the uploaded files as $_FILES['uploadify'] in your
     * PHP script.<br> Default:'Filedata'<br> Required:optional
     *
     * @param fileDataName
     * @return
     */
    public UploadifyOptions fileDataName(CharSequence fileDataName) {
        super.put("fileDataName", fileDataName);
        return this;
    }

    /**
     * The fileDesc option sets the text that will appear in the file type drop down in the file selection system
     * window. This option is required when using the fileExt option.<br> Default:null<br> Required:optional - required
     * when using fileExt
     *
     * @param fileDesc
     * @return
     */
    public UploadifyOptions fileDesc(CharSequence fileDesc) {
        super.put("fileDesc", fileDesc);
        return this;
    }

    /**
     * The fileExt options allows you to limit uploads to the specified file types. This feature can be easily bypassed
     * so it is highly recommended that you validate uploaded file types in the back-end script. This option only limits
     * what files are listed in the file selection system window. The fileDesc option is required when using the fileExt
     * option.<br> Input Format:'*.ext;*.ext;*.ext;...'<br> Default:null (all files allowed)<br> Required:optional<br>
     *
     * @param fileExt
     * @return
     */
    public UploadifyOptions fileExt(CharSequence fileExt) {
        super.put("fileExt", fileExt);
        return this;
    }

    /**
     * The height options sets the height of the flash button file in pixels.<br> Default:30<br> Required:optional
     *
     * @param height
     * @return
     */
    public UploadifyOptions height(int height) {
        super.put("height", height);
        return this;
    }

    /**
     * The hideButton option allows you to set the opacity of the flash button to 0 so you can style the underlying DIV.
     * The wmode option should be set to ‘transparent’ when using this option.<br> Default:false<br> Required:optional
     *
     * @param hideButton
     * @return
     */
    public UploadifyOptions hideButton(boolean hideButton) {
        super.put("hideButton", hideButton);
        return this;
    }

    /**
     * The method option sets the form submission method for the file uploads. This affects the way your variables are
     * referenced in the back-end script.<br> Input Format:'POST' / 'GET'<br> Default:'POST'<br> Required:optional
     *
     * @param method
     * @return
     */
    public UploadifyOptions method(CharSequence method) {
        super.put("method", method);
        return this;
    }

    /**
     * The multi option allows the user to add multiple files to the queue for upload.<br> Default:false<br>
     * Required:optional
     *
     * @param multi
     * @return
     */
    public UploadifyOptions multi(boolean multi) {
        super.put("multi", multi);
        return this;
    }

    /**
     * The queueID option allows you to set any DOM element with a unique ID as the container for the file upload queue.
     * If this option is omitted, the plug-in creates a new file queue container below the flash button.<br>
     * Default:null<br> Required:optional
     *
     * @param queueID
     * @return
     */
    public UploadifyOptions queueID(CharSequence queueID) {
        super.put("queueID", queueID);
        return this;
    }

    /**
     * The queueSizeLimit options allows you to set the maximum number of files that can exist in the queue at one time.
     * If the user tries to add more the the maximum limit, the onQueueFull function is triggered. The multi option
     * should be used in conjunction with this option.<br> Default:999<br> Required:optional
     *
     * @param queueSizeLimit
     * @return
     */
    public UploadifyOptions queueSizeLimit(int queueSizeLimit) {
        super.put("queueSizeLimit", queueSizeLimit);
        return this;
    }

    /**
     * Disabling this option will keep the completed file upload queue items in the queue until the close button is
     * clicked or the queue is cleared.<br> Default:true<br> Required:optional
     *
     * @param removeCompleted
     * @return
     */
    public UploadifyOptions removeCompleted(boolean removeCompleted) {
        super.put("removeCompleted", removeCompleted);
        return this;
    }

    /**
     * Enabling the rollover option will activate rollover states for the flash button. Rollover buttons have their
     * hover and active states in the same file below the off state (see example). This option should be used in
     * conjunction with the buttonImg option.<br> Default:false<br> Required:optional
     *
     * @param rollover
     * @return
     */
    public UploadifyOptions rollover(boolean rollover) {
        super.put("rollover", rollover);
        return this;
    }

    /**
     * The script option is required and points to the back-end script that will process your files. The back-end script
     * can be written in any server-side language. The Uploadify zip package comes with a PHP script that can be
     * modified to suit your needs.<br> Default:null<br> Required:required
     *
     * @param script
     * @return
     */
    public UploadifyOptions script(CharSequence script) {
        super.put("script", script);
        return this;
    }

    /**
     * The scriptAccess option sets the scriptAccess property for the flash button file. Setting this option to "always"
     * can alleviate some issues during testing that involve communication problems between the flash file and the HTML
     * page if they are in different domains. For security purposes, "sameDomain" should be used in the production
     * environment.<br> Input Format:'sameDomain' / 'always'<br> Default:'sameDomain'<br> Required:optional
     *
     * @param scriptAccess
     * @return
     */
    public UploadifyOptions scriptAccess(CharSequence scriptAccess) {
        super.put("scriptAccess", scriptAccess);
        return this;
    }

    /**
     * The scriptData option allows you to send additional data to the back-end script during an upload. You can call
     * the scriptData values in the back-end script like any submitted form field (i.e. $_POST['scriptDataVariable']).
     * To send dynamic values, you can use this option in conjunction with the .uploadifySettings() method.<br>
     * Default:null<br> Required:optional
     *
     * @param scriptData
     * @return
     */
    public UploadifyOptions scriptData(CharSequence scriptData) {
        if (scriptData instanceof JQLiteral)
            super.put("scriptData", scriptData);
        else
            super.put("scriptData", JQLiteral._raw(scriptData));
        return this;
    }

    /**
     * The simUploadLimit option allows you to set the maximum number of uploads that can run simultaneously.<br>
     * Default:1<br> Required:optional
     *
     * @param simUploadLimit
     * @return
     */
    public UploadifyOptions simUploadLimit(int simUploadLimit) {
        super.put("simUploadLimit", simUploadLimit);
        return this;
    }

    /**
     * The sizeLimit option allows you to set the maximum file size allowed per file in bytes. If the file exceeds the
     * size limit, it will return an error on upload.<br> Default:null<br> Required:optional
     *
     * @param sizeLimit
     * @return
     */
    public UploadifyOptions sizeLimit(int sizeLimit) {
        super.put("sizeLimit", sizeLimit);
        return this;
    }

    /**
     * The path to the uploadify.swf file. <br> Default:null<br> Required:optional
     *
     * @param uploader
     * @return
     */
    public UploadifyOptions uploader(CharSequence uploader) {
        super.put("uploader", uploader);
        return this;
    }

    /**
     * The width option sets the width of the flash button file in pixels.<br> Default:120<br> Required:optional
     *
     * @param width
     * @return
     */
    public UploadifyOptions width(int width) {
        super.put("width", width);
        return this;
    }

    /**
     * The wmode option sets the wmode of the flash button. Setting wmode to ‘transparent’ will make the background of
     * the file transparent, but it will be the top most layer of your page. If you have a nearby select and the drop
     * down overlaps the flash button with a wmode set to ‘transparent,’ the drop down will appear to be under the flash
     * button.<br> Default:'opaque'<br> Required:optional
     *
     * @param wmode
     * @return
     */
    public UploadifyOptions wmode(Wmode wmode) {
        super.put("wmode", wmode);
        return this;
    }

    /**
     * The onAllComplete option allows you to set a custom function that will fire when all the files in the queue have
     * finished uploading. The default function clears the error array. If you set your custom function to return false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br> data An object containing details about the upload.<br> <ul> <li>[filesUploaded] –
     * The total number of files uploaded</li> <li>[errors] – The total number of errors encountered>/li>
     * <li>[allBytesLoaded] – The total number of bytes uploaded</li> <li>[speed] – The average upload speed in
     * KB/s</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onAllCompleteEvent(CharSequence callbackBody) {
        return this.onAllCompleteEvent(js(callbackBody));
    }

    /**
     * The onAllComplete option allows you to set a custom function that will fire when all the files in the queue have
     * finished uploading. The default function clears the error array. If you set your custom function to return false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br> data An object containing details about the upload.<br> <ul> <li>[filesUploaded] –
     * The total number of files uploaded</li> <li>[errors] – The total number of errors encountered>/li>
     * <li>[allBytesLoaded] – The total number of bytes uploaded</li> <li>[speed] – The average upload speed in
     * KB/s</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onAllCompleteEvent(IJQStatement callbackBody) {
        return this.onAllCompleteEvent($f(callbackBody).withParams("event",
                "data"));
    }

    /**
     * The onAllComplete option allows you to set a custom function that will fire when all the files in the queue have
     * finished uploading. The default function clears the error array. If you set your custom function to return false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br> data An object containing details about the upload.<br> <ul> <li>[filesUploaded] –
     * The total number of files uploaded</li> <li>[errors] – The total number of errors encountered>/li>
     * <li>[allBytesLoaded] – The total number of bytes uploaded</li> <li>[speed] – The average upload speed in
     * KB/s</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onAllCompleteEvent(IJQFunction callback) {
        super.put("onAllComplete", callback);
        return this;
    }

    /**
     * The onCancel option allows you to run a custom function when a file upload is canceled. The default function
     * removes the file item from the queue. This function will also fire for each file when the queue is cleared. If
     * the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> ID The unique identifier of the file that was cancelled.<br> fileObj An object
     * containing details about the file that was selected.<br> <ul> <li>[name] – The name of the file</li> <li>[size] –
     * The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li> <li>[modificationDate]
     * – The last date the file was modified</li> <li>[type] – The file extension beginning with a ‘.’ data Details
     * about the file queue.</li> <li>[fileCount] – The total number of files left in the queue</li> <li>[allBytesTotal]
     * – The total number of bytes left for all files in the queue</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCancelEvent(CharSequence callbackBody) {
        return this.onCancelEvent(js(callbackBody));
    }

    /**
     * The onCancel option allows you to run a custom function when a file upload is canceled. The default function
     * removes the file item from the queue. This function will also fire for each file when the queue is cleared. If
     * the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> ID The unique identifier of the file that was cancelled.<br> fileObj An object
     * containing details about the file that was selected.<br> <ul> <li>[name] – The name of the file</li> <li>[size] –
     * The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li> <li>[modificationDate]
     * – The last date the file was modified</li> <li>[type] – The file extension beginning with a ‘.’ data Details
     * about the file queue.</li> <li>[fileCount] – The total number of files left in the queue</li> <li>[allBytesTotal]
     * – The total number of bytes left for all files in the queue</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCancelEvent(IJQStatement callbackBody) {
        return this.onCancelEvent($f(callbackBody).withParams("event", "ID",
                "fileObj", "data"));
    }

    /**
     * The onCancel option allows you to run a custom function when a file upload is canceled. The default function
     * removes the file item from the queue. This function will also fire for each file when the queue is cleared. If
     * the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> ID The unique identifier of the file that was cancelled.<br> fileObj An object
     * containing details about the file that was selected.<br> <ul> <li>[name] – The name of the file</li> <li>[size] –
     * The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li> <li>[modificationDate]
     * – The last date the file was modified</li> <li>[type] – The file extension beginning with a ‘.’ data Details
     * about the file queue.</li> <li>[fileCount] – The total number of files left in the queue</li> <li>[allBytesTotal]
     * – The total number of bytes left for all files in the queue</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onCancelEvent(IJQFunction callback) {
        super.put("onCancel", callback);
        return this;
    }

    /**
     * The onCheck option allows you to execute a function when a file with the same name is found on the server. The
     * check begins right before the files are uploaded. The default function prompts the user for confirmation of
     * upload over the existing file and cancels the upload if not confirmed. If your custom function returns false, the
     * default function will not run. The checkScript option must be used in tandem with this option.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> data An object containing the list of file names that exist on the server. The key
     * for each file name is the unique ID of the queue item.<br> key The unique ID queue item for the file that was
     * detected on the<br> server.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCheckEvent(CharSequence callbackBody) {
        return this.onCheckEvent(js(callbackBody));
    }

    /**
     * The onCheck option allows you to execute a function when a file with the same name is found on the server. The
     * check begins right before the files are uploaded. The default function prompts the user for confirmation of
     * upload over the existing file and cancels the upload if not confirmed. If your custom function returns false, the
     * default function will not run. The checkScript option must be used in tandem with this option.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> data An object containing the list of file names that exist on the server. The key
     * for each file name is the unique ID of the queue item.<br> key The unique ID queue item for the file that was
     * detected on the<br> server.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCheckEvent(IJQStatement callbackBody) {
        return this.onCheckEvent($f(callbackBody).withParams("event", "data",
                "key"));
    }

    /**
     * The onCheck option allows you to execute a function when a file with the same name is found on the server. The
     * check begins right before the files are uploaded. The default function prompts the user for confirmation of
     * upload over the existing file and cancels the upload if not confirmed. If your custom function returns false, the
     * default function will not run. The checkScript option must be used in tandem with this option.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br> data An object containing the list of file names that exist on the server. The key
     * for each file name is the unique ID of the queue item.<br> key The unique ID queue item for the file that was
     * detected on the<br> server.
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onCheckEvent(IJQFunction callback) {
        super.put("onCheck", callback);
        return this;
    }

    /**
     * The onClearQueue option allows you to run a custom function when the queue is cleared via the
     * .uploadifyClearQueue() method. The default function removes all items from the queue. If the custom function
     * returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onClearQueueEvent(CharSequence callbackBody) {
        return this.onClearQueueEvent(js(callbackBody));
    }

    /**
     * The onClearQueue option allows you to run a custom function when the queue is cleared via the
     * .uploadifyClearQueue() method. The default function removes all items from the queue. If the custom function
     * returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onClearQueueEvent(IJQStatement callbackBody) {
        return this.onClearQueueEvent($f(callbackBody).withParams("event"));
    }

    /**
     * The onClearQueue option allows you to run a custom function when the queue is cleared via the
     * .uploadifyClearQueue() method. The default function removes all items from the queue. If the custom function
     * returns false, the default function will not run.<br>
     * <p/>
     * Arguments<br>
     * <p/>
     * event The event object.<br>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onClearQueueEvent(IJQFunction callback) {
        super.put("onClearQueue", callback);
        return this;
    }

    /**
     * The onComplete function allows you to fire a custom function when each file has completed uploading. The default
     * function marks the file queue item as complete and if the removeCompleted option is enabled, will remove the file
     * queue item from the queue. If the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique ID of the file queue item.<br>
     * <p/>
     * fileObj An object containing the file information.<br> <ul> <li>[name] – The name of the uploaded file</li>
     * <li>[filePath] – The path on the server to the uploaded file</li> <li>[size] – The size in bytes of the file</li>
     * <li>[creationDate] – The date the file was created</li> <li>[modificationDate] – The last date the file was
     * modified</li> <li>[type] – The file extension beginning with a ‘.’ response The text response sent back from the
     * back-end upload script.</li> </ul>
     * <p/>
     * data An object containing general data about the upload and the queue.<br> <ul> <li>[fileCount] – The number of
     * files remaining in the queue</li> <li>[speed] – The average speed pf the file upload in KB/s</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCompleteEvent(CharSequence callbackBody) {
        return this.onCompleteEvent(js(callbackBody));
    }

    /**
     * The onComplete function allows you to fire a custom function when each file has completed uploading. The default
     * function marks the file queue item as complete and if the removeCompleted option is enabled, will remove the file
     * queue item from the queue. If the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique ID of the file queue item.<br>
     * <p/>
     * fileObj An object containing the file information.<br> <ul> <li>[name] – The name of the uploaded file</li>
     * <li>[filePath] – The path on the server to the uploaded file</li> <li>[size] – The size in bytes of the file</li>
     * <li>[creationDate] – The date the file was created</li> <li>[modificationDate] – The last date the file was
     * modified</li> <li>[type] – The file extension beginning with a ‘.’ response The text response sent back from the
     * back-end upload script.</li> </ul>
     * <p/>
     * data An object containing general data about the upload and the queue.<br> <ul> <li>[fileCount] – The number of
     * files remaining in the queue</li> <li>[speed] – The average speed pf the file upload in KB/s</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onCompleteEvent(IJQStatement callbackBody) {
        return this.onCompleteEvent($f(callbackBody).withParams("event", "ID",
                "fileObj", "response", "data"));
    }

    /**
     * The onComplete function allows you to fire a custom function when each file has completed uploading. The default
     * function marks the file queue item as complete and if the removeCompleted option is enabled, will remove the file
     * queue item from the queue. If the custom function returns false, the default function will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique ID of the file queue item.<br>
     * <p/>
     * fileObj An object containing the file information.<br> <ul> <li>[name] – The name of the uploaded file</li>
     * <li>[filePath] – The path on the server to the uploaded file</li> <li>[size] – The size in bytes of the file</li>
     * <li>[creationDate] – The date the file was created</li> <li>[modificationDate] – The last date the file was
     * modified</li> <li>[type] – The file extension beginning with a ‘.’ response The text response sent back from the
     * back-end upload script.</li> </ul>
     * <p/>
     * data An object containing general data about the upload and the queue.<br> <ul> <li>[fileCount] – The number of
     * files remaining in the queue</li> <li>[speed] – The average speed pf the file upload in KB/s</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onCompleteEvent(IJQFunction callback) {
        super.put("onComplete", callback);
        return this;
    }

    /**
     * The onError option allows you to fire a custom function when an error is returned during upload. The default
     * function add the error class to the file queue item. If your custom function returns false, the default function
     * will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that returned an error.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     * <p/>
     * <p/>
     * errorObj An object containing details about the error returned.<br> <ul> <li>[type] – Either ‘HTTP’, ‘IO’, or
     * ‘Security’</li> <li>[info] – An error message describing the type of error returned</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onErrorEvent(CharSequence callbackBody) {
        return this.onErrorEvent(js(callbackBody));
    }

    /**
     * The onError option allows you to fire a custom function when an error is returned during upload. The default
     * function add the error class to the file queue item. If your custom function returns false, the default function
     * will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that returned an error.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     * <p/>
     * <p/>
     * errorObj An object containing details about the error returned.<br> <ul> <li>[type] – Either ‘HTTP’, ‘IO’, or
     * ‘Security’</li> <li>[info] – An error message describing the type of error returned</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onErrorEvent(IJQStatement callbackBody) {
        return this.onErrorEvent($f(callbackBody).withParams("event", "ID",
                "fileObj", "errorObj"));
    }

    /**
     * The onError option allows you to fire a custom function when an error is returned during upload. The default
     * function add the error class to the file queue item. If your custom function returns false, the default function
     * will not run.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that returned an error.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     * <p/>
     * <p/>
     * errorObj An object containing details about the error returned.<br> <ul> <li>[type] – Either ‘HTTP’, ‘IO’, or
     * ‘Security’</li> <li>[info] – An error message describing the type of error returned</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onErrorEvent(IJQFunction callback) {
        super.put("onError", callback);
        return this;
    }

    /**
     * The onInit option allows you to run a custom function when the Uploadify plug-in is initiated. The default
     * function hides the DOM element that Uploadify was applied to, then creates an instance of the flash button and a
     * file queue. If the custom function returns false, the default function will not run—but why would you want to do
     * that?<br>
     * <p/>
     * No arguments.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onInitEvent(CharSequence callbackBody) {
        return this.onInitEvent(js(callbackBody));
    }

    /**
     * The onInit option allows you to run a custom function when the Uploadify plug-in is initiated. The default
     * function hides the DOM element that Uploadify was applied to, then creates an instance of the flash button and a
     * file queue. If the custom function returns false, the default function will not run—but why would you want to do
     * that?<br>
     * <p/>
     * No arguments.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onInitEvent(IJQStatement callbackBody) {
        return this.onInitEvent($f(callbackBody));
    }

    /**
     * The onInit option allows you to run a custom function when the Uploadify plug-in is initiated. The default
     * function hides the DOM element that Uploadify was applied to, then creates an instance of the flash button and a
     * file queue. If the custom function returns false, the default function will not run—but why would you want to do
     * that?<br>
     * <p/>
     * No arguments.
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onInitEvent(IJQFunction callback) {
        super.put("onInit", callback);
        return this;
    }

    /**
     * The onOpen option allows you to fire a custom function when a file is opened for upload. There is no default
     * function for this option. Due to synchronicity issues, changing the scriptData via the .uploadifySettings()
     * method will not work properly inside an onOpen custom function.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was opened.<br>
     * <p/>
     * fileObj An object containing details about the file that was opened.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onOpenEvent(CharSequence callbackBody) {
        return this.onOpenEvent(js(callbackBody));
    }

    /**
     * The onOpen option allows you to fire a custom function when a file is opened for upload. There is no default
     * function for this option. Due to synchronicity issues, changing the scriptData via the .uploadifySettings()
     * method will not work properly inside an onOpen custom function.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was opened.<br>
     * <p/>
     * fileObj An object containing details about the file that was opened.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onOpenEvent(IJQStatement callbackBody) {
        return this.onOpenEvent($f(callbackBody).withParams("event", "ID",
                "fileObj"));
    }

    /**
     * The onOpen option allows you to fire a custom function when a file is opened for upload. There is no default
     * function for this option. Due to synchronicity issues, changing the scriptData via the .uploadifySettings()
     * method will not work properly inside an onOpen custom function.<br>
     * <p/>
     * Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was opened.<br>
     * <p/>
     * fileObj An object containing details about the file that was opened.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onOpenEvent(IJQFunction callback) {
        super.put("onOpen", callback);
        return this;
    }

    /**
     * The onProgress option allows you to fire a function each time to progress of a file upload changes. The default
     * function updates the length of the progress bar and percentage displayed. If the custom function returns false,
     * the default function will not run. <br> Argumetns:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file being uploaded.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul> <br>
     * <p/>
     * data An object containing details about the upload and queue.<br> <ul> <li>[percentage] – The current percentage
     * completed for the upload</li> <li>[bytesLoaded] – The current amount of bytes uploaded</li> <li>[allBytesLoaded]
     * – The current amount of bytes loaded for all files in the queue [speed] – The current upload speed in KB/s</li>
     * </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onProgressEvent(CharSequence callbackBody) {
        return this.onProgressEvent(js(callbackBody));
    }

    /**
     * The onProgress option allows you to fire a function each time to progress of a file upload changes. The default
     * function updates the length of the progress bar and percentage displayed. If the custom function returns false,
     * the default function will not run. <br> Argumetns:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file being uploaded.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul> <br>
     * <p/>
     * data An object containing details about the upload and queue.<br> <ul> <li>[percentage] – The current percentage
     * completed for the upload</li> <li>[bytesLoaded] – The current amount of bytes uploaded</li> <li>[allBytesLoaded]
     * – The current amount of bytes loaded for all files in the queue [speed] – The current upload speed in KB/s</li>
     * </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onProgressEvent(IJQStatement callbackBody) {
        return this.onProgressEvent($f(callbackBody).withParams("event", "ID",
                "fileObj", "data"));
    }

    /**
     * The onProgress option allows you to fire a function each time to progress of a file upload changes. The default
     * function updates the length of the progress bar and percentage displayed. If the custom function returns false,
     * the default function will not run. <br> Argumetns:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file being uploaded.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul> <br>
     * <p/>
     * data An object containing details about the upload and queue.<br> <ul> <li>[percentage] – The current percentage
     * completed for the upload</li> <li>[bytesLoaded] – The current amount of bytes uploaded</li> <li>[allBytesLoaded]
     * – The current amount of bytes loaded for all files in the queue [speed] – The current upload speed in KB/s</li>
     * </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onProgressEvent(IJQFunction callback) {
        super.put("onProgress", callback);
        return this;
    }

    /**
     * The onQueueFull option allows you to run a custom function when the number of files in the queue as set by the
     * queueSizeLimit option is exceeded. The default function alerts the user that the queue is full and notes the
     * maximum amount of files in the queue. If more than the number of allowed files is selected in one action, the
     * allowed number of files are added to the queue and the event is triggered. If the custom function returns false,
     * the default function does not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * queueSizeLimit The maximum size of the queue as set by the queueSizeLimit option.<br>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onQueueFullEvent(CharSequence callbackBody) {
        return this.onQueueFullEvent(js(callbackBody));
    }

    /**
     * The onQueueFull option allows you to run a custom function when the number of files in the queue as set by the
     * queueSizeLimit option is exceeded. The default function alerts the user that the queue is full and notes the
     * maximum amount of files in the queue. If more than the number of allowed files is selected in one action, the
     * allowed number of files are added to the queue and the event is triggered. If the custom function returns false,
     * the default function does not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * queueSizeLimit The maximum size of the queue as set by the queueSizeLimit option.<br>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onQueueFullEvent(IJQStatement callbackBody) {
        return this.onQueueFullEvent($f(callbackBody).withParams("event",
                "queueSizeLimit"));
    }

    /**
     * The onQueueFull option allows you to run a custom function when the number of files in the queue as set by the
     * queueSizeLimit option is exceeded. The default function alerts the user that the queue is full and notes the
     * maximum amount of files in the queue. If more than the number of allowed files is selected in one action, the
     * allowed number of files are added to the queue and the event is triggered. If the custom function returns false,
     * the default function does not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * queueSizeLimit The maximum size of the queue as set by the queueSizeLimit option.<br>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onQueueFullEvent(IJQFunction callback) {
        super.put("onQueueFull", callback);
        return this;
    }

    /**
     * The onSelect option allows you to run a custom function for each file when being added to the queue. The default
     * function creates a new queue item for the file and places it in the queue. If the custom function returns false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was selected.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSelectEvent(CharSequence callbackBody) {
        return this.onSelectEvent(js(callbackBody));
    }

    /**
     * The onSelect option allows you to run a custom function for each file when being added to the queue. The default
     * function creates a new queue item for the file and places it in the queue. If the custom function returns false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was selected.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSelectEvent(IJQStatement callbackBody) {
        return this.onSelectEvent($f(callbackBody).withParams("event", "ID",
                "fileObj"));
    }

    /**
     * The onSelect option allows you to run a custom function for each file when being added to the queue. The default
     * function creates a new queue item for the file and places it in the queue. If the custom function returns false,
     * the default function will not run. <br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * ID The unique identifier of the file that was selected.<br>
     * <p/>
     * fileObj An object containing details about the file that was selected.<br> <ul> <li>[name] – The name of the
     * file</li> <li>[size] – The size in bytes of the file</li> <li>[creationDate] – The date the file was created</li>
     * <li>[modificationDate] – The last date the file was modified</li> <li>[type] – The file extension beginning with
     * a ‘.’</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onSelectEvent(IJQFunction callback) {
        super.put("onSelect", callback);
        return this;
    }

    /**
     * The onSelectOnce option allows you to run a custom function once each time files are added to the queue. There is
     * no default function for this option.<br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * data An object containing details about the select operation.<br> <ul> <li>[fileCount] – The total number of
     * files in the queue</li> <li>[filesSelected] – The number of files selected in the select operation</li>
     * <li>[filesReplaced] – The number of files that were replaced in the queue</li> <li>[allBytesTotal] – The total
     * number of bytes for all files in the queue</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSelectOnceEvent(CharSequence callbackBody) {
        return this.onSelectOnceEvent(js(callbackBody));
    }

    /**
     * The onSelectOnce option allows you to run a custom function once each time files are added to the queue. There is
     * no default function for this option.<br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * data An object containing details about the select operation.<br> <ul> <li>[fileCount] – The total number of
     * files in the queue</li> <li>[filesSelected] – The number of files selected in the select operation</li>
     * <li>[filesReplaced] – The number of files that were replaced in the queue</li> <li>[allBytesTotal] – The total
     * number of bytes for all files in the queue</li> </ul>
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSelectOnceEvent(IJQStatement callbackBody) {
        return this.onSelectOnceEvent($f(callbackBody).withParams("event",
                "data"));
    }

    /**
     * The onSelectOnce option allows you to run a custom function once each time files are added to the queue. There is
     * no default function for this option.<br> Arguments:<br>
     * <p/>
     * event The event object.<br>
     * <p/>
     * data An object containing details about the select operation.<br> <ul> <li>[fileCount] – The total number of
     * files in the queue</li> <li>[filesSelected] – The number of files selected in the select operation</li>
     * <li>[filesReplaced] – The number of files that were replaced in the queue</li> <li>[allBytesTotal] – The total
     * number of bytes for all files in the queue</li> </ul>
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onSelectOnceEvent(IJQFunction callback) {
        super.put("onSelectOnce", callback);
        return this;
    }

    /**
     * The onSWFReady option allows you to run a custom function when the flash button is loaded and ready. This option
     * is useful for running actions that are dependent upon the flash file. There is no default function for this
     * option.
     * <p/>
     * <p/>
     * No arguments.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSWFReadyEvent(CharSequence callbackBody) {
        return this.onSWFReadyEvent(js(callbackBody));
    }

    /**
     * The onSWFReady option allows you to run a custom function when the flash button is loaded and ready. This option
     * is useful for running actions that are dependent upon the flash file. There is no default function for this
     * option.
     * <p/>
     * <p/>
     * No arguments.
     *
     * @param callbackBody
     * @return
     */
    public UploadifyOptions onSWFReadyEvent(IJQStatement callbackBody) {
        return this.onSWFReadyEvent($f(callbackBody));
    }

    /**
     * The onSWFReady option allows you to run a custom function when the flash button is loaded and ready. This option
     * is useful for running actions that are dependent upon the flash file. There is no default function for this
     * option.
     * <p/>
     * <p/>
     * No arguments.
     *
     * @param callback
     * @return
     */
    public UploadifyOptions onSWFReadyEvent(IJQFunction callback) {
        super.put("onSWFReady", callback);
        return this;
    }

}
