package sample;

import java.util.Date;

/**
 * Класс для создания выборки организаций
 */

public class Organization {

    /**
     * Поля класса. Соответствуют полям БД
     */

    private Integer idOrganization;
    private String nameOrganization;
    private String addressOrganization;
    private String emailOrganization;
    private String siteOrganization;
    private Date workStartOrganization;
    private Date workEndOrganization;
    private String descriptionOrganization;

    private String specializationOrganization;
    private String propertyOrganization;

    private Integer idSpecializationOrganization;
    private Integer idPropertyOrganization;

    /**
     * Конструктор для создания выборки организаций
     * @param nameOrganization
     * @param addressOrganization
     * @param emailOrganization
     * @param siteOrganization
     * @param workStartOrganization
     * @param workEndOrganization
     * @param descriptionOrganization
     * @param specializationOrganization
     * @param propertyOrganization
     */

    public Organization(String nameOrganization, String addressOrganization, String emailOrganization,
                        String siteOrganization, Date workStartOrganization, Date workEndOrganization,
                        String descriptionOrganization, String specializationOrganization,
                        String propertyOrganization) {
        this.nameOrganization = nameOrganization;
        this.addressOrganization = addressOrganization;
        this.emailOrganization = emailOrganization;
        this.siteOrganization = siteOrganization;
        this.workStartOrganization = workStartOrganization;
        this.workEndOrganization = workEndOrganization;
        this.descriptionOrganization = descriptionOrganization;
        this.specializationOrganization = specializationOrganization;
        this.propertyOrganization = propertyOrganization;
    }

    /**
     * getter and setter для получения доступа к приватным полям класса.
     */

    public Integer getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(Integer idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getAddressOrganization() {
        return addressOrganization;
    }

    public void setAddressOrganization(String addressOrganization) {
        this.addressOrganization = addressOrganization;
    }

    public String getEmailOrganization() {
        return emailOrganization;
    }

    public void setEmailOrganization(String emailOrganization) {
        this.emailOrganization = emailOrganization;
    }

    public String getSiteOrganization() {
        return siteOrganization;
    }

    public void setSiteOrganization(String siteOrganization) {
        this.siteOrganization = siteOrganization;
    }

    public Date getWorkStartOrganization() {
        return workStartOrganization;
    }

    public void setWorkStartOrganization(Date workStartOrganization) {
        this.workStartOrganization = workStartOrganization;
    }

    public Date getWorkEndOrganization() {
        return workEndOrganization;
    }

    public void setWorkEndOrganization(Date workEndOrganization) {
        this.workEndOrganization = workEndOrganization;
    }

    public String getDescriptionOrganization() {
        return descriptionOrganization;
    }

    public void setDescriptionOrganization(String descriptionOrganization) {
        this.descriptionOrganization = descriptionOrganization;
    }

    public String getSpecializationOrganization() {
        return specializationOrganization;
    }

    public void setSpecializationOrganization(String specializationOrganization) {
        this.specializationOrganization = specializationOrganization;
    }

    public String getPropertyOrganization() {
        return propertyOrganization;
    }

    public void setPropertyOrganization(String propertyOrganization) {
        this.propertyOrganization = propertyOrganization;
    }

    public Integer getIdSpecializationOrganization() {
        return idSpecializationOrganization;
    }

    public void setIdSpecializationOrganization(Integer idSpecializationOrganization) {
        this.idSpecializationOrganization = idSpecializationOrganization;
    }

    public Integer getIdPropertyOrganization() {
        return idPropertyOrganization;
    }

    public void setIdPropertyOrganization(Integer idPropertyOrganization) {
        this.idPropertyOrganization = idPropertyOrganization;
    }
}
