package com.lister.mrlister.mrlester;

import com.lister.mrlister.mrlester.data.ItemsNewProduct;

import java.util.Comparator;


public class SortFile {

    public static FilesComparator getComparator(SortParameter... sortParameters) {
        return new FilesComparator(sortParameters);
    }

    public enum SortParameter {
        ID_NAME
    }

    private static class FilesComparator implements Comparator<ItemsNewProduct> {
        private SortParameter[] parameters;

        private FilesComparator(SortParameter[] parameters) {
            this.parameters = parameters;
        }

        public int compare(ItemsNewProduct o1, ItemsNewProduct o2) {
            int comparison;
            for (SortParameter parameter : parameters) {
                switch (parameter) {
                    case ID_NAME:
                        comparison = o2.getChecked() - o1.getChecked();
                        if (comparison != 0) return comparison;
                        break;
                }
            }
            return 0;
        }
    }

}
