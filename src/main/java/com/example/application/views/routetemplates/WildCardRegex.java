package com.example.application.views.routetemplates;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "api/:path*(com|vaadin|flow)", layout = MainLayout.class)
@PermitAll
public class WildCardRegex extends HorizontalLayout implements BeforeEnterObserver {

    private final TextArea textArea = new TextArea();

    public WildCardRegex() {
        textArea.setValue("Wild Card RegEx Route Template");
        add(textArea);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        var arg = event.getRouteParameters().get("path");
        arg.ifPresent(s -> textArea.setValue(String.format("wild card regex path: %s", s)));
    }
}
