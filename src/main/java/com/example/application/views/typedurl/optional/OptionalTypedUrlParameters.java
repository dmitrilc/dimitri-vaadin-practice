package com.example.application.views.typedurl.optional;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;

import javax.annotation.Nullable;
import javax.annotation.security.PermitAll;

@PageTitle("Optional Typed URL Parameters")
@Route(value = "optionalTypedUrlParameters", layout = MainLayout.class) //will be inside parent
@PermitAll
public class OptionalTypedUrlParameters
        extends HorizontalLayout
        implements HasUrlParameter<String>
{
    private final TextArea textArea = new TextArea();

    public OptionalTypedUrlParameters() {
        textArea.setValue("Optional Typed URL Parameters");
        add(textArea);
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter @Nullable String parameter) {
        textArea.setValue(String.format("Optional Typed URL Parameter: %s!", parameter));
    }
}