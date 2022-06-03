package com.example.application.views.typedurl.wildcard;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;

@PageTitle("WildCard Typed URL Parameters")
@Route(value = "wildCardTypedUrlParameters", layout = MainLayout.class) //will be inside parent
@PermitAll
public class WildCardTypedUrlParameters
        extends HorizontalLayout
        implements HasUrlParameter<String>
{
    private final TextArea textArea = new TextArea();

    public WildCardTypedUrlParameters() {
        textArea.setValue("WildCard Typed URL Parameters");
        add(textArea);
    }

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        if (parameter.isEmpty()) {
            textArea.setValue("Welcome anonymous.");
        } else {
            textArea.setValue(String.format("Handling parameter %s.", parameter));
        }
    }
}
