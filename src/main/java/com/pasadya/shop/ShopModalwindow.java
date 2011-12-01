package com.pasadya.shop;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.model.IModel;

public class ShopModalwindow extends ModalWindow {
	  private static final long serialVersionUID = 1L;

      /**
       * @param id
       */
      public ShopModalwindow(String id) {
              super(id);
      }

      /**
       * @param id
       * @param model
       */
      public ShopModalwindow(String id, IModel<?> model) {
              super(id, model);
      }

      /**
       * Adds the JavaScript to initially open modal window.
       */
      public void renderHead(IHeaderResponse response)
      {
              
      }

      /*
       * (non-Javadoc)
       * @see org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow#makeContentVisible()
       */
      @Override
      protected boolean makeContentVisible()
      {
              return true;
      }

}
