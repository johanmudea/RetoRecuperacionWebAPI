package co.com.sofka.model;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

public class Category {

    @Generated("jsonschema2pojo")

        private Integer categoryId;
        private String name;
        private String nicename;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNicename() {
            return nicename;
        }

        public void setNicename(String nicename) {
            this.nicename = nicename;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }


}