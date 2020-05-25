# demo-jpa

Repo with jpa/hibernate examples

## Annotations @ID @GeneratedValue
If there is @GeneratedValue annotation on Id field, if we manually set the id via setter method or constructor we receive an error


## Parent/child relationship

If we have a relation between two entity whe have two way to persiste each entity:
	* Persist explicitly parent and child
	* Put cascade option on parent entity. In this way the child entity will be automatically stored
