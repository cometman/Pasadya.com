package com.google.code.jqwicket.servlet;

import com.google.code.jqwicket.Utils;
import org.apache.wicket.util.file.FileCleaner;
import org.apache.wicket.util.upload.DiskFileItemFactory;
import org.apache.wicket.util.upload.FileItem;
import org.apache.wicket.util.upload.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(req)) {
            System.out.println("not an upload...");
            return;
        }
        try {

            ServletFileUpload upload = new ServletFileUpload(
                    new DiskFileItemFactory(new FileCleaner()));
            List<FileItem> items = upload.parseRequest(req);

            for (FileItem item : items) {

                if (Utils.isBlank(item.getName()))
                    continue;

                System.out.println("item-name: " + item.getName());
                System.out.println("item-type: " + item.getContentType());
                System.out.println("item-size: " + item.getSize());

                File targetFolder = new File(
                        System.getProperty("java.io.tmpdir"), "uploadify");
                if (!targetFolder.exists())
                    targetFolder.mkdirs();

                item.write(new File(targetFolder, item.getName()));
            }

            resp.getWriter().println("http://localhost:8080/jqwicket-demo/uploadify");
            resp.getWriter().flush();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
