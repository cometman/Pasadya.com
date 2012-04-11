package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.validationengine.*;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.value.ValueMap;

public class ValidationEnginePage extends DemoPage {

    public ValidationEnginePage() {
        add(new ValidationEngineForm("veForm"));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
     */
    @Override
    protected String getExampleTitle() {
        return "JQuery ValidationEngine Plugin example";
    }

    private static class ValidationEngineForm extends Form<Void> {

        private static final long serialVersionUID = 1L;

        private final ValueMap properties = new ValueMap();

        public ValidationEngineForm(String id) {
            super(id);
            super.setDefaultModel(new CompoundPropertyModel<ValueMap>(
                    properties));

            add(new ValidationEngineFormBehavior(
                    new ValidationEngineOptions()
                            .addValidationRules(new AjaxUserRule1(
                                    "ajaxUserTest1"), new AjaxUserRule2(
                                    "ajaxUserTest2"),
                                    new Validate2FieldsFuncRule(
                                            "func_validate2fields"))));

            add(new TextField<String>("user").setType(String.class).add(
                    new ValidationEngineFormComponentBehavior("required",
                            "custom[noSpecialCharacters]", "length[0,20]",
                            "ajax[ajaxUserTest1]", "ajax[ajaxUserTest2]")));

            add(new TextField<String>("firstname").setType(String.class).add(
                    new ValidationEngineFormComponentBehavior(
                            "optional,custom[onlyLetter],length[0,100]")));

            add(new TextField<String>("lastname")
                    .setType(String.class)
                    .add(new ValidationEngineFormComponentBehavior(
                            "required,custom[onlyLetter],funcCall[func_validate2fields],length[0,100]")));

        }



    }

    private static class Validate2FieldsFuncRule extends FuncValidationRule {

        private static final long serialVersionUID = 1L;

        private static String js = "function func_validate2fields(){"
                + "if($('#firstname').val() == '' ||  $('#lastname').val() == ''){"
                + "return false;" //
                + "}else{" //
                + "return true;" + "}" + "}";

        public Validate2FieldsFuncRule(CharSequence name) {
            super(name, "func_validate2fields", js,
                    "* You must have a firstname and a lastname");
        }

    }

    private static class AjaxUserRule1 extends AjaxValidationRule {

        private static final long serialVersionUID = 1L;

        public AjaxUserRule1(String name) {
            super(name, "..user ok...", "loading rule 1", "... user not ok...");
        }

        @Override
        protected boolean execute(ExecutionContext ctx) {
            // sleep to display "loading" indicator to
            // the user
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                ;
            }

            if ("test".equals(ctx.getValue()))
                return true;

            return false;
        }

    }

    private static class AjaxUserRule2 extends AjaxValidationRule {

        private static final long serialVersionUID = 1L;

        public AjaxUserRule2(String name) {
            super(name, "..user ok...", "loading rule 2", "... user not ok...");
        }

        @Override
        protected boolean execute(ExecutionContext ctx) {
            if ("test".equals(ctx.getValue()))
                return true;

            return false;
        }

    }
}
