# hibernate-learning

###Some Notes to Remember 

 - Optimistic Locking (using @Version) for more information check this https://www.baeldung.com/jpa-optimistic-locking :
                                      
                                      This instructs Hibernate
                                      that we would like to use an optimistic locking mechanism, using the version
                                      attribute as a control. Every time Hibernate updates a record, it compares the
                                      version of the entity instance to that of the record in the database. If both versions
                                      are the same, it means that no one updated the data before, and Hibernate will
                                      update the data and increment the version column. However, if the version is not
                                      the same, it means that someone has updated the record before, and Hibernate
                                      will throw a StaleObjectStateException exception, which Spring will translate to
                                      HibernateOptimisticLockingFailureException. The example we used an integer
                                      for version control. In addition to an integer, Hibernate supports using a timestamp.
                                      However, using an integer for version control is recommended since Hibernate
                                      will always increment the version number by 1 after each update. When using a
                                      timestamp, Hibernate will update the latest timestamp after each update.
                                      A timestamp is slightly less safe because two concurrent transactions may both load
                                      and update the same item in the same millisecond.
                                       

  - @Temporal(TemporalType.DATE) : 
  
                                    we annotate it with @Temporal, using the
                                    TemporalType.DATE value as an argument. This means we would like to map the
                                    data type from the Java date type (java.util.Date) to the SQL date type
                                    (java.sql.Date). This allows us to access the attribute birthDate in the Singer
                                    object by using java.util.Date as usual in our application                                    
                                      