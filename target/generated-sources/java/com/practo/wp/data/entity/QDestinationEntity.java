package com.practo.wp.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDestinationEntity is a Querydsl query type for DestinationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDestinationEntity extends EntityPathBase<DestinationEntity> {

    private static final long serialVersionUID = -1997330665L;

    public static final QDestinationEntity destinationEntity = new QDestinationEntity("destinationEntity");

    public final NumberPath<Integer> destinationId = createNumber("destinationId", Integer.class);

    public final NumberPath<Integer> distance = createNumber("distance", Integer.class);

    public final StringPath location = createString("location");

    public final ListPath<TripEntity, QTripEntity> trips = this.<TripEntity, QTripEntity>createList("trips", TripEntity.class, QTripEntity.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    public QDestinationEntity(String variable) {
        super(DestinationEntity.class, forVariable(variable));
    }

    public QDestinationEntity(Path<? extends DestinationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDestinationEntity(PathMetadata metadata) {
        super(DestinationEntity.class, metadata);
    }

}

