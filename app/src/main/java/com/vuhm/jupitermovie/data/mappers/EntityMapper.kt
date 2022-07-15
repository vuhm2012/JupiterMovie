package com.vuhm.jupitermovie.data.mappers

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity

    fun mapFromEntityList(list: List<Entity>): List<DomainModel>

    fun mapToEntityList(list: List<DomainModel>): List<Entity>
}