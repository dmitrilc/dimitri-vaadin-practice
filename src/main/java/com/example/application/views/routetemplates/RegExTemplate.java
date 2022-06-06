package com.example.application.views.routetemplates;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;

@Route(value = "user/:userID?([0-9]{1,9})", layout = MainLayout.class)
@PermitAll
public class RegExTemplate extends HorizontalLayout implements BeforeEnterObserver {
    private final TextArea textArea = new TextArea();

    public RegExTemplate() {
        textArea.setValue("RegEx Route Template");
        add(textArea);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        var arg = event.getRouteParameters().get("userID");
        arg.ifPresent(s -> textArea.setValue(String.format("regex path: %s", s)));
    }
}
