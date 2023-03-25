package com.example.application.views.list;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class ContactForm extends FormLayout {

    TextField firstName = new TextField("firstName");
    TextField lastName = new TextField("lastName");

    EmailField email = new EmailField("email");

    ComboBox<Status> status = new ComboBox<>("Status");
    ComboBox<Company> company = new ComboBox<>("Company");

    Button saveButtonForm = new Button("Save Data");
    Button deleteButtonForm = new Button("Delete Data");
    Button canceButtonForm = new Button("Cancel Data");


    public ContactForm(List<Status> statueses, List<Company> companies) {

        addClassName("contact-form");

        company.setItems(companies);
        company.setItemLabelGenerator(Company::getName); // get name company

        status.setItems(statueses);
        status.setItemLabelGenerator(Status::getName); // get status name


        add(
                firstName,
                lastName,
                status,
                company,
                createButtonComponent()
        );
    }

    private Component createButtonComponent() {
        saveButtonForm.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteButtonForm.addThemeVariants(ButtonVariant.LUMO_ERROR);
        canceButtonForm.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        deleteButtonForm.addClickShortcut(Key.ENTER);
        canceButtonForm.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(saveButtonForm,deleteButtonForm,canceButtonForm);
    }
}
