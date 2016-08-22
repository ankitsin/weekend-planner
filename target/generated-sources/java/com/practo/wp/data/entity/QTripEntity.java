package com.practo.wp.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTripEntity is a Querydsl query type for TripEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTripEntity extends EntityPathBase<TripEntity> {

    private static final long serialVersionUID = 708938146L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTripEntity tripEntity = new QTripEntity("tripEntity");

    public final NumberPath<Integer> averageCost = createNumber("averageCost", Integer.class);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final QDestinationEntity destination;

    public final DatePath<java.util.Date> goingDate = createDate("goingDate", java.util.Date.class);

    public final NumberPath<Integer> goingPeople = createNumber("goingPeople", Integer.class);

    public final NumberPath<Byte> isDeleted = createNumber("isDeleted", Byte.class);

    public final DateTimePath<java.util.Date> modifiedAt = createDateTime("modifiedAt", java.util.Date.class);

    public final NumberPath<Integer> numOfDay = createNumber("numOfDay", Integer.class);

    public final NumberPath<Integer> spaceLeft = createNumber("spaceLeft", Integer.class);

    public final NumberPath<Integer> tripId = createNumber("tripId", Integer.class);

    public final StringPath tripName = createString("tripName");

    public final QUserEntity user;

    public QTripEntity(String variable) {
        this(TripEntity.class, forVariable(variable), INITS);
    }

    public QTripEntity(Path<? extends TripEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTripEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTripEntity(PathMetadata metadata, PathInits inits) {
        this(TripEntity.class, metadata, inits);
    }

    public QTripEntity(Class<? extends TripEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.destination = inits.isInitialized("destination") ? new QDestinationEntity(forProperty("destination")) : null;
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

