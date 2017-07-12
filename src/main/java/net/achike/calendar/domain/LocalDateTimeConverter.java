package net.achike.calendar.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
        return entityValue == null ? null : Timestamp.valueOf(entityValue);
    }

    @Override
    public java.time.LocalDateTime convertToEntityAttribute(Timestamp dbValue) {
        return dbValue == null ? null : dbValue.toLocalDateTime();
    }
}
