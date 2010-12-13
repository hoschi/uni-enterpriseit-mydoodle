package de.uniluebeck.itm.ep5.poll.domain;

import java.util.LinkedList;
import java.util.List;

public class PollMapper {

    public static boPoll createBO(xoPoll poll) {
        boPoll result = new boPoll();
        result.setId(poll.getId());
        result.setPublic(poll.isPublic());
        result.setTitle(poll.getTitle());
        result.setStartDate(poll.getStartDate());
        result.setEndDate(poll.getEndDate());
        result.setOptions(createBO(poll.getOptionLists()));
        return result;
    }

    public static List<BOOptionList> createBO(List<XOOptionList> options) {
        if (options == null) {
            return null;
        }
        List<BOOptionList> result = new LinkedList<BOOptionList>();
        for (XOOptionList list : options) {
            result.add(createBO(list));
        }
        return result;
    }

    public static BOOptionList createBO(XOOptionList list) {
        BOOptionList result = new BOOptionList();
        result.setId(list.getId());
        result.setTitle(list.getTitle());
        result.setDates(createBO(result, list.getDates(), true));
        result.setTexts(createBO(result, list.getTexts(), false));
        return result;
    }

    public static List<IOption> createBO(BOOptionList parentList, List<IOption> list, boolean dates) {
        List<IOption> result = new LinkedList<IOption>();
        if (dates) {
            for (IOption option : list) {
                result.add(createBO(parentList, (XODateOption)option));
            }
        } else {
            for (IOption option : list) {
                result.add(createBO(parentList, (XOTextOption)option));
            }
        }
        return result;
    }

    public static BODateOption createBO(BOOptionList parentList, XODateOption option) {
        BODateOption result = new BODateOption();
        result.setId(option.getId());
        result.setList(parentList);
        return result;
    }

    public static BOTextOption createBO(BOOptionList parentList, XOTextOption option) {
        BOTextOption result = new BOTextOption();
        result.setId(option.getId());
        //result.setStrings(option.getStrings());
        result.setList(parentList);
        return result;
    }





    public static xoPoll createXO(boPoll poll) {
        xoPoll result = new xoPoll();
        result.setId(poll.getId());
        result.setPublic(poll.isPublic());
        result.setTitle(poll.getTitle());
        result.setStartDate(poll.getStartDate());
        result.setEndDate(poll.getEndDate());
        result.setOptions(createXO(poll.getOptions()));
        return result;
    }

    public static List<XOOptionList> createXO(List<BOOptionList> options) {
        if (options == null) {
            return null;
        }
        List<XOOptionList> result = new LinkedList<XOOptionList>();
        for (BOOptionList list : options) {
            result.add(createXO(list));
        }
        return result;
    }

    public static XOOptionList createXO(BOOptionList list) {
        XOOptionList result = new XOOptionList();
        result.setId(list.getId());
        result.setTitle(list.getTitle());
        result.setDates(createXO(result, list.getDates(), true));
        result.setTexts(createXO(result, list.getTexts(), false));
        return result;
    }

    public static List<IOption> createXO(XOOptionList parentList, List<IOption> list, boolean dates) {
        List<IOption> result = new LinkedList<IOption>();
        if (dates) {
            for (IOption option : list) {
                result.add(createXO(parentList, (BODateOption)option));
            }
        } else {
            for (IOption option : list) {
                result.add(createXO(parentList, (BOTextOption)option));
            }
        }
        return result;
    }

    public static XODateOption createXO(XOOptionList parentList, BODateOption option) {
        XODateOption result = new XODateOption();
        result.setId(option.getId());
        result.setList(parentList);
        return result;
    }

    public static XOTextOption createXO(XOOptionList parentList, BOTextOption option) {
        XOTextOption result = new XOTextOption();
        result.setId(option.getId());
        //result.setStrings(option.getStrings());
        result.setList(parentList);
        return result;
    }
}
