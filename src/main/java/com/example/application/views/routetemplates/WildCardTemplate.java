package com.example.application.views.routetemplates;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;

@Route(value = "api/:path*", layout = MainLayout.class)
@RoutePrefix("api_prefix")
@RouteAlias("apiAlias/:path*")
@PermitAll
public class WildCardTemplate extends HorizontalLayout implements BeforeEnterObserver {
    private final TextArea textArea = new TextArea();

    public WildCardTemplate() {
        textArea.setValue("WildCard Route Template");
        add(textArea);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        var arg = event.getRouteParameters().get("path");
        arg.ifPresent(s -> textArea.setValue(String.format("wild card path: %s!", s)));
    }
}
