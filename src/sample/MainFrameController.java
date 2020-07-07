package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainFrameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Organization> tableOrganizations;

    @FXML
    private TableColumn<String, Organization> tableOrganizationsName;

    @FXML
    private TableColumn<String, Organization> tableOraganizationsSpecialization;

    @FXML
    private TableColumn<String, Organization> tableOraganizationsEmail;

    @FXML
    private TableColumn<String, Organization> tableOraganizationsSite;

    @FXML
    private TableColumn<String, Organization> tableOrganizationsAdress;

    @FXML
    private TableColumn<String, Organization> tableOraganizationsWorkStart;

    @FXML
    private TableColumn<String, Organization> tableOrganizationsWorkEnd;

    @FXML
    private TableColumn<String, Organization> tableOrganizationsProperty;

    @FXML
    private TableView<PhoneNumbers> tableNumbers;

    @FXML
    private TableColumn<String, PhoneNumbers> TableNumbersNumber;

    @FXML
    private TableColumn<Boolean, PhoneNumbers> tableNumbersFax;

    @FXML
    private TableColumn<String, PhoneNumbers> tableNumbersCategories;

    @FXML
    private Button buttonRefreshOrganizationsTable;

    @FXML
    private TextField textFieldAdress;

    @FXML
    private TextField textFieldName;

    @FXML
    private Button buttonClearFields;


    @FXML
    private Button buttonRefreshLists;

    @FXML
    private TableView<List> tableSpecialize;

    @FXML
    private TableColumn<String, List> columnSpecializeName;

    @FXML
    private TableColumn<String, List> columnSpecializeCount;

    @FXML
    private TableView<List> tableProperty;

    @FXML
    private TableColumn<String, List> tablePropertyName;

    @FXML
    private TableColumn<String, List> tablePropertyNum;


    @FXML
    void initialize() {
        //устанавление значений в таблицы один раз при инициализации
        cellOrganizationTable();
        cellTablePhoneNumbers();
        cellTableList(columnSpecializeName,columnSpecializeCount);
        cellTableList(tablePropertyName, tablePropertyNum);
    }

    /**
     * Обновление таблицы организаций
     * @param event
     */

    @FXML
    void buttonRefreshOrganizationsTableEvent(ActionEvent event) {
        //получение названия организации и названия сайта из fields
        String siteOrg = textFieldAdress.getText().trim();
        String nameOrg = textFieldName.getText().trim();
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        tableOrganizations.setItems(dataBaseHandler.getOrganizationInfo(nameOrg,siteOrg));
    }

    /**
     * Вывод номеров телефона при выборе организации в таблице "Организации"
     * @param event
     */

    @FXML
    void numberRefreshEvent(MouseEvent event) {
        if (!tableOrganizations.getItems().isEmpty()) {
            //получение выбранного объекта из таблицы организаций
            Organization organization = tableOrganizations.getSelectionModel().getSelectedItem();
            //получение id организации
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            organization = dataBaseHandler.getOrganizationIdByNameInfo(organization);

            tableNumbers.setItems(dataBaseHandler.getPhoneNumbersInfo(organization.getIdOrganization()));
        }
    }

    /**
     * Очистить фильтры
     * @param event
     */

    @FXML
    void buttonClearFieldsEvent(ActionEvent event) {
        textFieldAdress.clear();
        textFieldName.clear();
    }

    /**
     * Обновлений списков специализации и форм собственности
     * @param event
     */
    @FXML
    void buttonRefreshListsEvent(ActionEvent event) {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        tableProperty.setItems(dataBaseHandler.getPropertyList());
        tableSpecialize.setItems(dataBaseHandler.getSpecializationList());
    }


    /**
     * Установка полей таблицы в fxml форме
     */

    public void cellOrganizationTable () {
        tableOrganizationsName.setCellValueFactory(new PropertyValueFactory<>("nameOrganization"));
        tableOraganizationsSpecialization.setCellValueFactory(new PropertyValueFactory<>("specializationOrganization"));
        tableOraganizationsEmail.setCellValueFactory(new PropertyValueFactory<>("emailOrganization"));
        tableOraganizationsSite.setCellValueFactory(new PropertyValueFactory<>("siteOrganization"));
        tableOrganizationsAdress.setCellValueFactory(new PropertyValueFactory<>("addressOrganization"));
        tableOraganizationsWorkStart.setCellValueFactory(new PropertyValueFactory<>("workStartOrganization"));
        tableOrganizationsWorkEnd.setCellValueFactory(new PropertyValueFactory<>("workEndOrganization"));
        tableOrganizationsProperty.setCellValueFactory(new PropertyValueFactory<>("propertyOrganization"));
    }

    /**
     * Устновка полей в таблице номеров телефонов
     */

    public void cellTablePhoneNumbers (){
        TableNumbersNumber.setCellValueFactory(new PropertyValueFactory<>("numberPhoneNumbers"));
        tableNumbersCategories.setCellValueFactory(new PropertyValueFactory<>("categoryPhoneNumbers"));
        tableNumbersFax.setCellValueFactory(new PropertyValueFactory<>("faxPhoneNumbers"));
    }

    /**
     * Установка таблицы списков и форм собственности
     * @param column1
     * @param column2
     */
    public void cellTableList (TableColumn <String, List> column1, TableColumn <String, List> column2){
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("count"));
    }


    /**
     * Изменение цвета кнопок при наведении на них мышкой
     * @param event
     */

    @FXML
    void buttonClearFieldsOnMouseEntered(MouseEvent event) {

    }


    @FXML
    void buttonRefreshOrganizationsTableOnMouseEntered(MouseEvent event) {
    }
}
