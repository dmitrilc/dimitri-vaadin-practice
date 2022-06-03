package com.example.application.views.typedurl;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        //Code below attempts to use query parameters
        Location location = event.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();

        Map<String, List<String>> parametersMap = queryParameters
                .getParameters();

        Grid<Person> grid = new Grid<>();

        var list = List.of(new Person(
                parametersMap.get("firstName").get(0),
                parametersMap.get("lastName").get(0))
        );

        grid.setItems(list);
        grid.addColumn(Person::firstName).setHeader("First Name");
        grid.addColumn(Person::lastName).setHeader("Last Name");

        add(grid);
    }
}

record Person(String firstName, String lastName) {}