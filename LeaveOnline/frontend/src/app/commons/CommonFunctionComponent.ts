export class CommonFunctionComponent {
    constructor(){}

    getDiffdate(startDate,endDate) : string{
        let startDateCal = new Date(startDate);
        let endDateCal = endDate?new Date(endDate):new Date();
        var duration = endDateCal.valueOf() - startDateCal.valueOf();
        
        let diffDate = new Date(duration);
        let durationYear = diffDate.getFullYear() - 1970;
        let durationMonth = diffDate.getMonth();
        let durationDate = diffDate.getDate();
        
      
        return durationYear+" ปี "+durationMonth+" เดือน "+durationDate+" วัน";
     }
}