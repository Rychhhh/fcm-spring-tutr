package com.example.application.views.list;

import com.example.application.data.entity.Contact;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import java.util.Collections;

@PageTitle("Contact | CRM SPRINGBOOT")
@Route(value = "")
public class ListView extends VerticalLayout {
    // ini untuk table
    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField fieldText = new TextField();

    ContactForm form;

    public ListView() {
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();
        add(
                getToolbar(),
                getContent()
        );
    }

    private Component getContent() {
       HorizontalLayout content =  new HorizontalLayout(grid, form);
       content.setFlexGrow(2, grid);  // space for grid table
        content.setFlexGrow(1, form); // space for form
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private Component getToolbar() {
        fieldText.setPlaceholder("Filter by Name...");
        fieldText.setClearButtonVisible(true);
        fieldText.setValueChangeMode(ValueChangeMode.LAZY);

        Button add_contact = new Button("Add Contact");

        HorizontalLayout toolbar = new HorizontalLayout(fieldText, add_contact);

        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email");
        grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true)); // get auto field width
    }



    private void configureForm() {
        form = new ContactForm(Collections.emptyList(), Collections.emptyList());
     form.setWidth("25em");
    }

}
