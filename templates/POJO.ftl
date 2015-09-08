package ${packageName}.${beanName};

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;


/**
* ${zTable.comment!""}
*/
@Table("${zTable.tableName}")
public class ${zTable.className} {

	<#list zTable.fields as zField>
	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	<#if zField.primaryKey == true>
	<#if zField.classTypeName == "Long" || zField.classTypeName == "Integer">
	@Id
	<#else>
	<#if zField.classTypeName == "String">
	@Name
	</#if>
	</#if>
	</#if>
	@Column("${zField.dbFieldName}")
	private ${zField.classTypeName} ${zField.fieldName};
	
	</#list>
	
	<#list zTable.fields as zField>

	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	public ${zField.classTypeName} get${zField.fieldName?cap_first}(){
		return ${zField.fieldName};
	}
	
	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	public void set${zField.fieldName?cap_first}(${zField.classTypeName} ${zField.fieldName}){
		this.${zField.fieldName} = ${zField.fieldName};
	}
	</#list>
}
