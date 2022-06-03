package com.example.application.views.typedurl;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
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
    private final TextArea textArea = new TextArea();

    public TypedUrlParameters() {
        textArea.setValue("Typed URL Parameters");
        add(textArea);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        textArea.setValue(String.format("Typed URL Parameter: %s!", parameter));
    }
}
