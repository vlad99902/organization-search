package sample;

/**
 * Класс для заполнения таблицы номеров телефона
 */

public class PhoneNumbers {
    /**
     * Поля класса соотнесенные с БД
     */
    private Integer idPhoneNumbers;
    private String numberPhoneNumbers;
    private Boolean faxPhoneNumbers;

    private String categoryPhoneNumbers;
    private String organizationPhoneNumbers;

    private Integer idCategoryPhoneNumbers;
    private Integer idOrganizationPhoneNumbers;

    /**
     * Конструктор для создания выборки номеров телефона
     * @param numberPhoneNumbers
     * @param faxPhoneNumbers
     * @param categoryPhoneNumbers
     */
    public PhoneNumbers(String numberPhoneNumbers, Boolean faxPhoneNumbers, String categoryPhoneNumbers) {
        this.numberPhoneNumbers = numberPhoneNumbers;
        this.faxPhoneNumbers = faxPhoneNumbers;
        this.categoryPhoneNumbers = categoryPhoneNumbers;
    }

    /**
     * getter and setter для получения доступа к приватным полям класса
     */

    public Integer getIdPhoneNumbers() {
        return idPhoneNumbers;
    }

    public void setIdPhoneNumbers(Integer idPhoneNumbers) {
        this.idPhoneNumbers = idPhoneNumbers;
    }

    public String getNumberPhoneNumbers() {
        return numberPhoneNumbers;
    }

    public void setNumberPhoneNumbers(String numberPhoneNumbers) {
        this.numberPhoneNumbers = numberPhoneNumbers;
    }

    public Boolean getFaxPhoneNumbers() {
        return faxPhoneNumbers;
    }

    public void setFaxPhoneNumbers(Boolean faxPhoneNumbers) {
        this.faxPhoneNumbers = faxPhoneNumbers;
    }

    public String getCategoryPhoneNumbers() {
        return categoryPhoneNumbers;
    }

    public void setCategoryPhoneNumbers(String categoryPhoneNumbers) {
        this.categoryPhoneNumbers = categoryPhoneNumbers;
    }

    public String getOrganizationPhoneNumbers() {
        return organizationPhoneNumbers;
    }

    public void setOrganizationPhoneNumbers(String organizationPhoneNumbers) {
        this.organizationPhoneNumbers = organizationPhoneNumbers;
    }

    public Integer getIdCategoryPhoneNumbers() {
        return idCategoryPhoneNumbers;
    }

    public void setIdCategoryPhoneNumbers(Integer idCategoryPhoneNumbers) {
        this.idCategoryPhoneNumbers = idCategoryPhoneNumbers;
    }

    public Integer getIdOrganizationPhoneNumbers() {
        return idOrganizationPhoneNumbers;
    }

    public void setIdOrganizationPhoneNumbers(Integer idOrganizationPhoneNumbers) {
        this.idOrganizationPhoneNumbers = idOrganizationPhoneNumbers;
    }
}
