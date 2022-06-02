package com.example.application.views.typedurl;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Typed URL Parameters")
//@Route(value = "typedUrlParameters") //will not be inside parent
@Route(value = "typedUrlParameters", layout = MainLayout.class) //will be inside parent
@PermitAll
public class TypedUrlParameters
        extends HorizontalLayout
        implements HasUrlParameter<String>
{
    private final TextField textField = new TextField();

    public TypedUrlParameters() {
        textField.setValue("Typed URL Parameters");
        add(textField);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        textField.setValue(String.format("Hello, %s!", parameter));
    }
}
