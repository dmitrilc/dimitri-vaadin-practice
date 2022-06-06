package com.example.application.views.routetemplates;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;

//Can be access with
//http://localhost:8080/prefix_to_add/user/11/edit
//Or using alias
// http://localhost:8080/prefix_to_add/userAlias/11/edit

@Route(value = "user/:userID?/edit", layout = MainLayout.class)
@RoutePrefix("prefix_to_add")
@RouteAlias("userAlias/:userID?/edit")
@PermitAll
public class RouteTemplateOne extends HorizontalLayout implements BeforeEnterObserver {

    private final TextArea textArea = new TextArea();

    public RouteTemplateOne() {
        textArea.setValue("Route Template One");
        add(textArea);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        var arg = event.getRouteParameters().get("userId");
        arg.ifPresent(s -> textArea.setValue(String.format("User ID: %s!", s)));
    }
}